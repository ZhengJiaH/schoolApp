package com.app.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.app.controller.InitApp;
import com.app.dao.OrderTableMapper;
import com.app.model.InitPayUrlModel;
import com.app.model.OrderTable;
import com.app.service.InitPayUrl;
import com.app.utils.PublisState;
import com.app.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * @author 郑嘉豪
 * @date 2019/8/14
 * 获取支付链接的service，并持久化到数据库
 */

@Service
public class InitPayUrlImpl implements InitPayUrl {
    @Resource
    private InitApp initApp;
    @Resource
    private OrderTableMapper orderTableMapper;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private OrderTable orderTable;
    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;
    @Override
    public Object getPayUrl(InitPayUrlModel initPayUrlModel){
        System.out.println(initPayUrlModel);
        System.out.println(initPayUrlModel.getAliUserId());
        initPayUrlModel.setCustomDesc("电费支付");
        initPayUrlModel.setProductId("1504");
        initPayUrlModel.setOrgId("tellhowedu-ali");
        initPayUrlModel.setCallBackUrl("https://tellhowedu.haixiong.io/pay_success.html");
        initPayUrlModel.setTime(InitApp.data);
        initPayUrlModel.set_url("pay/order/customPay");
        //三分之一的概率产生
        if ((int) (Math.random() * 3)==1){
            System.out.println("===============");
            initPayUrlModel.setSysPid("2088131379018027");
        }
        System.out.println(initPayUrlModel);
        //获取嵌套的json数据  用JSON逐渐刨开
        Object object=restTemplate.postForObject("https://www.jiaofeidating.com/ecard-pay/webservice.php",initPayUrlModel,Object.class);
        System.out.println("--------------------------------->"+object);
        JSONObject jsonObject=JSON.parseObject(JSON.toJSONString(object));
        JSONObject jsonObject1=JSON.parseObject(JSON.toJSONString(jsonObject.get("result")));
        JSONObject jsonObject2=JSON.parseObject(JSON.toJSONString(jsonObject1.get("payOrder")));
        orderTable.setOrderNo(jsonObject2.getString("orderNo"));
        orderTable.setUserId(jsonObject2.getString("userId"));
        orderTable.setOrgId(jsonObject2.getString("orgId"));
        orderTable.setProductId(jsonObject2.getString("productId"));
        orderTable.setPaidAmount(jsonObject2.getInteger("allPayAmount"));
        orderTable.setXiaoqu_id(initPayUrlModel.getXiaoqu_id());
        orderTable.setLoudong_id(initPayUrlModel.getLoudong_id());
        orderTable.setRoom_id(initPayUrlModel.getRoom_id());
        orderTable.setCreateTime(jsonObject2.getString("createTime"));
        orderTable.setSnowId(snowflakeIdWorker.nextId());
        orderTable.setState(PublisState.PayState.NO.getName());
        orderTable.setSch_state(PublisState.PayState.NO.getName());
        System.out.println(orderTable);
        orderTableMapper.insertOrder(orderTable);
        return object;
    }
}
