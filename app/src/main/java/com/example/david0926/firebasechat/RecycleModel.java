package com.example.david0926.firebasechat;

public class RecycleModel{

    private String name, msg, time;

    public RecycleModel(){}

    public RecycleModel(String name, String msg, String time){
        this.name=name;
        this.msg=msg;
        this.time=time;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
