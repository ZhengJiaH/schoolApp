package com.app.controller;

import com.app.dao.CallBackUrlMapper;
import com.app.model.OrderTable;
import com.app.service.impl.CallBackUrlImpl;
import com.app.utils.PublisState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 丿郑不乖
 * @date
 * 支付成功后的回调链接
 * 回调链接学校提供，后续会改，这里测试
 */
@Controller
public class CallBackUrlController {
    @Resource
    private OrderTable orderTable;
    @Resource
    private CallBackUrlImpl callBackUrlimpl;
    @Resource
    private CallBackUrlMapper callBackUrlMapper;
    /***/
    @ResponseBody
    @RequestMapping(value = "/callBackUrl",method = RequestMethod.POST)
    public OrderTable callBackUrl(String orderNo){
        orderTable.setOrderNo(orderNo);
        orderTable.setState(PublisState.PayState.OK.getName());
        return callBackUrlimpl.updateByOrderNo(orderTable);
//        return callBackUrlMapper.saveByOrderNo(orderNo);
    }
}
