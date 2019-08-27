package com.app.utils;

public class PublisState {
    public enum PayState {
        //支付状态为未支付
        NO(0, "未支付"),
        //支付状态为支付成功
        OK(1, "已支付成功");

        PayState(int name, String value) {
            this.name = name;
            this.value = value;
        }

        private int name;
        private String value;

        public int getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }
}
