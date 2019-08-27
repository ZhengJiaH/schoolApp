package com.app.controller;

import com.app.model.InitPayUrlModel;
import com.app.service.impl.InitPayUrlImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

/**
 * @author 郑嘉豪
 * @date 2019/8/14
 * 生成发起支付链接
 */
@Controller
@RequestMapping(value = "/yunban",method = RequestMethod.POST)
public class InitPayUrlController {

    @Resource
    private InitPayUrlImpl initPayUrlImpl;

    @ResponseBody
    @RequestMapping(value = "/getPayUrl")
    public Object getPayUrl(@RequestBody InitPayUrlModel initPayUrlModel){
        return initPayUrlImpl.getPayUrl(initPayUrlModel);
    }

}
