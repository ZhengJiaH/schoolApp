package com.app.controller;

import com.app.utils.AccreditURL;
import com.app.utils.MD5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 丿郑不乖
 * 应用入口
 * 先检查有无openId
 */
@Controller
@RequestMapping(value = "/init")
public class InitApp {
    public static String data;
    @Resource
    private InitApp initApp;
    /**
     * 写死的值
     */
    private static final String key="42fa3cb0-79d3-4256-a34d-bb1d7d095a95";
    @Resource
    private RestTemplate restTemplate;
    @ResponseBody
    @RequestMapping(value = "/app")
    public Object init(HttpSession session){
        Map<String,String> map=new HashMap<>();
        map.put("authorize_url",AccreditURL.accreditURL());
        return map;
    }
    /**获取sign*/
    @ResponseBody
    @RequestMapping(value = "/getSign")
    public Object getSign(Integer paidAmount,String aliUserId,HttpSession session){
        session.setAttribute("aliUserId",aliUserId);
        System.out.println(paidAmount+"   ===   "+aliUserId);
        StringBuffer bf=new StringBuffer();
        String userId=aliUserId;
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        data = df.format(new Date());
        System.out.println(data);
        bf.append(aliUserId).append(data).append(paidAmount).append(key);
        System.out.println(bf.toString());
        //加密  小写
        String md5Str1=MD5Utils.encode1(bf.toString());
        //二次加密  大写
        String md5Str2=MD5Utils.encode2(md5Str1);
        Map<String,String> map=new HashMap<>();
        map.put("sign",md5Str2);
        return map;
    }
}
