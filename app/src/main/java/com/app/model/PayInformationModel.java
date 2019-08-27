package com.app.model;

/**
 * @author 郑嘉豪
 * @date 2019/8/14
 * 主动拉取缴费信息的传入参数
 */
public class PayInformationModel {
    /**固定链接*/
    private String _url;
    /**订单号*/
    private String orderNo;
    /**组织简码*/
    private String orgId;
    /**支付宝userid*/
    private String aliUserId;
    /**签名*/
    private String sign;

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAliUserId() {
        return aliUserId;
    }

    public void setAliUserId(String aliUserId) {
        this.aliUserId = aliUserId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
