package com.example.demo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class ResponseMessage {
    @ApiModelProperty(value = "错误码")
    private int code;

    @ApiModelProperty(value = "错误信息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private List data;

    public ResponseMessage() {
    }

    public ResponseMessage(int code) {
        this.code = code;
    }

    public ResponseMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseMessage(int code, String message, List data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public int hashCode() {
        return this.message.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null){
            ResponseMessage obj2 = (ResponseMessage)obj;
            return this.code == obj2.code && this.message != null && this.message.equals(obj2.message);
        }
        return false;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
