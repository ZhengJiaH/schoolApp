package com.app.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 丿郑不乖
 * @date
 * 支付表
 */
@Component
public class OrderTable {
    /**订单号*/
    private String orderNo;
    /**用户id*/
    private String userId;
    /**组织id*/
    private String orgId;
    /**缴费项id*/
    private String productId;
    /**支付金额*/
    private Integer paidAmount;
    /**校区id*/
    private Integer xiaoqu_id;
    /**楼栋id*/
    private Integer loudong_id;
    /**房间号id*/
    private Integer room_id;
    /**创建时间*/
    private String createTime;
    /**校方流水号*/
    private Long snowId;
    /**订单状态，0未支付，1支付成功*/
    private Integer state;
    /**推送状态，0未推送，1推送成功*/
    private Integer sch_state;
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Integer getXiaoqu_id() {
        return xiaoqu_id;
    }

    public void setXiaoqu_id(Integer xiaoqu_id) {
        this.xiaoqu_id = xiaoqu_id;
    }

    public Integer getLoudong_id() {
        return loudong_id;
    }

    public void setLoudong_id(Integer loudong_id) {
        this.loudong_id = loudong_id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getSnowId() {
        return snowId;
    }

    public void setSnowId(Long snowId) {
        this.snowId = snowId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSch_state() {
        return sch_state;
    }

    public void setSch_state(Integer sch_state) {
        this.sch_state = sch_state;
    }

    @Override
    public String toString() {
        return "OrderTable{" +
                "orderNo='" + orderNo + '\'' +
                ", userId='" + userId + '\'' +
                ", orgId='" + orgId + '\'' +
                ", productId='" + productId + '\'' +
                ", paidAmount=" + paidAmount +
                ", xiaoqu_id=" + xiaoqu_id +
                ", loudong_id=" + loudong_id +
                ", room_id=" + room_id +
                ", createTime='" + createTime + '\'' +
                ", snowId=" + snowId +
                ", state=" + state +
                ", sch_state=" + sch_state +
                '}';
    }
}
