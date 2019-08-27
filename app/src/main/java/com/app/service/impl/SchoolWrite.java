package com.app.service.impl;

import com.app.model.OrderTable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@Async
@Component
public class SchoolWrite {
    @Resource
    private RestTemplate restTemplate;
    public void write(OrderTable orderTable){
//        restTemplate.getForObject("http://127.0.0.1:8081/write?userId="+orderTable.getUserId()+"&xiaoqu_id="+orderTable.getXiaoqu_id()
////                        +"&room_id="+orderTable.getRoom_id()+"&paidAmount="+orderTable.getPaidAmount()
////                        +"&createTime="+orderTable.getCreateTime()+"&snowId="+orderTable.getSnowId(),Object.class);
        System.out.println("----------------------------------------------->"+orderTable);
        restTemplate.getForObject("http://171.34.42.27:81/write?userId="+orderTable.getUserId()+"&xiaoqu_id="+orderTable.getXiaoqu_id()
                +"&room_id="+orderTable.getRoom_id()+"&paidAmount="+orderTable.getPaidAmount()
                +"&createTime="+orderTable.getCreateTime()+"&snowId="+orderTable.getSnowId(),Object.class);
    }
}