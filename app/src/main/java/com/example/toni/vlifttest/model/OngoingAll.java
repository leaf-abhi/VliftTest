package com.example.toni.vlifttest.model;

public class OngoingAll {
    private String data;
    private String desc;
    private OngoingAll() {
        //private constructor
    }
    public String getData() {
        return data;
    }

    public String getDesc() {
        return desc;
    }

    public static class Builder {
        private String data;
        private String desc;
        public Builder() {

        }

        public OngoingAll build() {
            OngoingAll ongoingAll = new OngoingAll();
            ongoingAll.data = this.data;
            ongoingAll.desc = this.desc;
            return ongoingAll;
        }

        public Builder setData(String data) {
            this.data = data;
            return this;
        }

        public Builder setDesc(String desc) {
            this.desc = desc;
            return this;
        }
    }
}
