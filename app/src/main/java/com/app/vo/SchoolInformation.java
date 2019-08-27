package com.app.vo;

/**
 * @author 丿郑不乖
 * @date 2019/8/15
 * 学校房间信息表
 */
public class SchoolInformation {
    /**学校校区名*/
    private String xiaoqu;
    /**学校校区id*/
    private Integer xiaoqu_id;
    /**楼栋名*/
    private String Loudong;
    /**楼栋id*/
    private Integer loudong_id;
    /**房间名*/
    private String room;
    /**房间id*/
    private Integer room_id;

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
}
