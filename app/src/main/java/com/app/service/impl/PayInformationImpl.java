package com.app.service.impl;

import com.app.model.PayInformationModel;
import com.app.service.PayInformation;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
/**
 * @author 郑嘉豪
 * @date 2019/8/14
 * 主动拉取支付信息service
 */
@Service
public class PayInformationImpl implements PayInformation {
    @Resource
    private RestTemplate restTemplate;
    @Override
    public Object pullPayInformation(PayInformationModel payInformationModel) {
        return restTemplate.postForObject("https://www.jiaofeidating.com/ecard-pay/webservice.php",payInformationModel,Object.class);
    }
}
