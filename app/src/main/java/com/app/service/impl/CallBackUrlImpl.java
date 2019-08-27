package com.app.service.impl;

import com.app.dao.CallBackUrlMapper;
import com.app.model.OrderTable;
import com.app.service.CallBackUrl;
import com.app.utils.PublisState;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 丿郑不乖
 */
@Service
public class CallBackUrlImpl implements CallBackUrl {
    @Resource
    private SchoolWrite schoolWrite;
    @Resource
    private CallBackUrlMapper callBackUrlMapper;
    @Override
    public OrderTable updateByOrderNo(OrderTable orderTable){
        //更改支付状态
        callBackUrlMapper.updateByOrderNo(orderTable);
        //异步校方入库  1.根据orderNo查询所有信息   2.将信写入校方数据库
        OrderTable orderTable1=callBackUrlMapper.saveByOrderNo(orderTable.getOrderNo());
        System.out.println(orderTable1);
        schoolWrite.write(orderTable1);
        orderTable.setSch_state(PublisState.PayState.OK.getName());
        callBackUrlMapper.updateSch_state(orderTable);
        return orderTable1;
    }
}