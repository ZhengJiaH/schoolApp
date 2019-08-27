package com.app.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.app.dao.CallBackUrlMapper;
import com.app.dao.OrderTableMapper;
import com.app.model.OrderTable;
import com.app.model.PayInformationModel;
import com.app.service.impl.CallBackUrlImpl;
import com.app.service.impl.PayInformationImpl;
import com.app.service.impl.SchoolWrite;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时任务,用于防止学校掉单，从而手动写入，
 * @author 丿郑不乖
 * @date
 */
@Component
public class TimingTask {
    @Resource
    private SchoolWrite schoolWrite;
    @Resource
    private CallBackUrlMapper callBackUrlMapper;
    @Resource
    private PayInformationImpl payInformationImpl;
    /**
     * 主动拉取支付信息的相关配置
     */
    private static final String UEL="pay/order/customGetSuccessPayOrder";
    Map<String,String> linkedhashmap=null;
    @Resource
    private OrderTableMapper otMapper;
    //从数据库中查询状态为0的，但是已经缴费的信息（订单在5分钟内）
    @Scheduled(cron = "0 */5 * * * ?")
    public void timingTask() throws NoSuchAlgorithmException {
        List<OrderTable> listTable=otMapper.queryState(PublisState.PayState.NO.getName());
        //判断5分钟内是否有未支付的
        if (listTable.size()==0) {
            //5分钟内全部都支付过，返回
            return;
        }
        //依次将数据取出，与一卡通进行对比
        for(int i=0;i<listTable.size();i++){
            OrderTable orderTable=listTable.get(i);
            linkedhashmap=new LinkedHashMap<>(5);
            linkedhashmap.put("_url",UEL);
            linkedhashmap.put("orderNo",orderTable.getOrderNo());
            linkedhashmap.put("orgId",orderTable.getOrgId());
            linkedhashmap.put("aliUserId",orderTable.getUserId());
            linkedhashmap.put("sign",MD5Utils.encode1(orderTable.getOrderNo()+"#^S1234FRT"));
            //转化位json对象
            String str=JSON.toJSONString(linkedhashmap);
            PayInformationModel payInformationModel=JSON.parseObject(str,PayInformationModel.class);
            Object object=payInformationImpl.pullPayInformation(payInformationModel);
            System.out.println(object);
            JSONObject jsonObject=JSON.parseObject(JSON.toJSONString(object));
            JSONObject jsonObject1=JSON.parseObject(JSON.toJSONString(jsonObject.get("result")));
            //判断支付状态   如果为4   刷新库中的数据，并且添加到学校的数据库中
            if (jsonObject1.getInteger("orderStatus")==4) {
                //改变腾讯库中的状态
                orderTable.setOrderNo(orderTable.getOrderNo());
                orderTable.setState(PublisState.PayState.OK.getName());
                callBackUrlMapper.updateByOrderNo(orderTable);
                //刷新到校方数据库
                OrderTable orderTable1=callBackUrlMapper.saveByOrderNo(orderTable.getOrderNo());
                orderTable.setSch_state(PublisState.PayState.OK.getName());
                callBackUrlMapper.updateSch_state(orderTable);
                schoolWrite.write(orderTable1);
            }
        }
    }
}
