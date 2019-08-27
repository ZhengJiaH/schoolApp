package com.app.controller;

import com.app.model.PayInformationModel;
import com.app.service.impl.PayInformationImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
/**
 * @author 郑嘉豪
 * @date 2019/8/14
 * 主动拉取支付信息
 */
@Controller
@RequestMapping(value = "/yunban",method = RequestMethod.POST)
public class PayInformationController {
    @Resource
    private PayInformationImpl payInformationimpl;
    //主动拉取支付信息
    @ResponseBody
    @RequestMapping(value = "/pull/PayInformation")
    public Object getPayInformation(@RequestBody PayInformationModel payInformationModel){
        return payInformationimpl.pullPayInformation(payInformationModel);
    }
}
