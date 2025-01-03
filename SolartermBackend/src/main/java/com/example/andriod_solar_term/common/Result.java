package com.example.andriod_solar_term.common;


public class Result {

    private Integer code;
    private String msg;
    private String description;

    public Result(Integer code, String msg, String description) {
        this.code = code;
        this.msg = msg;
        this.description = description;
    }
}
