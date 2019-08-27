package com.app.model;

/**
 * @author 丿郑不乖
 * @date
 * 房间信息表
 */
public class KdRoomModel {
    /**校区名称*/
    private String xiaoqu;
    /**校区id号*/
    private Integer xiaoqu_id;
    /**楼栋名称*/
    private String Loudong;
    /**楼栋id号*/
    private Integer loudong_id;
    /**房间名称*/
    private String room;
    /**房间id号*/
    private Integer room_id;
    /**房间当前用电总量*/
    private Float usedAmp;
    /**房间购电电总量 （正或者零，-1表示出错）*/
    private Float allAmp;

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public Integer getXiaoqu_id() {
        return xiaoqu_id;
    }

    public void setXiaoqu_id(Integer xiaoqu_id) {
        this.xiaoqu_id = xiaoqu_id;
    }

    public String getLoudong() {
        return Loudong;
    }

    public void setLoudong(String loudong) {
        Loudong = loudong;
    }

    public Integer getLoudong_id() {
        return loudong_id;
    }

    public void setLoudong_id(Integer loudong_id) {
        this.loudong_id = loudong_id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Float getUsedAmp() {
        return usedAmp;
    }

    public void setUsedAmp(Float usedAmp) {
        this.usedAmp = usedAmp;
    }

    public Float getAllAmp() {
        return allAmp;
    }

    public void setAllAmp(Float allAmp) {
        this.allAmp = allAmp;
    }
}
