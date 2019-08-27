package com.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.app.dao.CallBackUrlMapper;
import com.app.model.OrderTable;
import com.app.service.impl.SchoolWrite;
import com.app.utils.PublisState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author
 * 云瓣异步通知接口
 */
@Controller
@RequestMapping(value = "/Payment")
public class Payment_notice {
    @Resource
    private SchoolWrite schoolWrite;
    @Resource
    private CallBackUrlMapper callBackUrlMapper;
    @ResponseBody
    @RequestMapping(value = "/notice",method = RequestMethod.POST)
    public Object PaymentNotice(@RequestBody Object object){
        JSONObject jsonObject=JSON.parseObject(JSON.toJSONString(object));
        Integer paidAmount=jsonObject.getInteger("paidAmount");
        String orderNo=jsonObject.getString("orderNo");
        String userId=jsonObject.getString("userId");
        String orgId=jsonObject.getString("orgId");
        OrderTable orderTable=callBackUrlMapper.saveByOrderNo(orderNo);
        System.out.println("orderTable===========>"+orderTable);
        if(orderTable!=null){
            if(orderTable.getState()==0){
                if ((userId.equals(orderTable.getUserId()))&&(paidAmount.equals(orderTable.getPaidAmount()))&&(orgId.equals(orderTable.getOrgId()))){
                    orderTable.setState(PublisState.PayState.OK.getName());
                    //写入数据库，并推送给校方数据库
                    callBackUrlMapper.updateByOrderNo(orderTable);
                    schoolWrite.write(orderTable);
                    return orderTable;
                }
            }
        }
        return "无数据";
    }
}
