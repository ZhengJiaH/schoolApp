package com.app.model;

/**
 * @author 郑嘉豪
 * @date 2019/8/14
 * 获取支付链接的传入参数
 */
public class InitPayUrlModel extends OrderTable{
    /**固定链接*/
    private String _url;
    /**支付金额*/
    private Integer paidAmount;
    /**回调链接*/
    private String callBackUrl;
    /**学校组织简码*/
    private String orgId;
    /**缴费项id*/
    private String productId;
    /**支付明细介绍*/
    private String customDesc;
    /**支付宝授权的userid*/
    private String aliUserId;
    /**签名*/
    private String sign;
    /**时间*/
    private String time;
    /**支付类型  0支付宝，1微信*/
    private String platFormOriginal;
    private String sysPid;
    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCustomDesc() {
        return customDesc;
    }

    public void setCustomDesc(String customDesc) {
        this.customDesc = customDesc;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlatFormOriginal() {
        return platFormOriginal;
    }

    public void setPlatFormOriginal(String platFormOriginal) {
        this.platFormOriginal = platFormOriginal;
    }

    public String getSysPid() {
        return sysPid;
    }

    public void setSysPid(String sysPid) {
        this.sysPid = sysPid;
    }

    @Override
    public String toString() {
        return "InitPayUrlModel{" +
                "_url='" + _url + '\'' +
                ", paidAmount=" + paidAmount +
                ", callBackUrl='" + callBackUrl + '\'' +
                ", orgId='" + orgId + '\'' +
                ", productId='" + productId + '\'' +
                ", customDesc='" + customDesc + '\'' +
                ", aliUserId='" + aliUserId + '\'' +
                ", sign='" + sign + '\'' +
                ", time='" + time + '\'' +
                ", platFormOriginal='" + platFormOriginal + '\'' +
                ", sysPid='" + sysPid + '\'' +
                '}';
    }
}
