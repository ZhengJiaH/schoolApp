package com.app.controller;

import com.app.model.KdRoomModel;
import com.app.utils.MD5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 郑嘉豪
 * @date 2019/8/15
 * 用于获取学校信息
 */
@Controller
@RequestMapping(value = "/getschool",method = RequestMethod.POST)
public class SchoolInformationController {
    @Resource
    private RestTemplate restTemplate;
    /**通过学校简码查询校区信息*/
    @ResponseBody
    @RequestMapping(value = "/getxiaoqu")
    public List<Object> getXiaoqu(){
        return restTemplate.getForObject("http://171.34.42.27:81/school/xiaoqu",List.class);
    }

    /**通过校区查询楼栋信息*/
    @ResponseBody
    @RequestMapping(value = "/getloudong")
    public List<Object> getloudong(Integer xiaoqu_id){
        return restTemplate.getForObject("http://171.34.42.27:81/school/loudong?xiaoqu_id="+xiaoqu_id,List.class);
    }

    /**通过学校楼栋查询房间名称*/
    @ResponseBody
    @RequestMapping(value = "/getroom")
    public List<Object> getRomm(Integer loudong_id,Integer xiaoqu_id){
        return restTemplate.getForObject("http://171.34.42.27:81/school/room?loudong_id="+loudong_id+"&xiaoqu_id="+xiaoqu_id,List.class);
    }

    /**通过房间名查询剩余电量*/
    @ResponseBody
    @RequestMapping(value = "/getusedAmp")
    public Object getUserdAmp(Integer room_id,Integer loudong_id,Integer xiaoqu_id){
        return restTemplate.getForObject("http://171.34.42.27:81/school/usedAmp?room_id="+room_id+"&loudong_id="+loudong_id+"&xiaoqu_id="+xiaoqu_id,Object.class);
    }
}
