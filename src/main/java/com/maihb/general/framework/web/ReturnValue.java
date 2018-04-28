package com.maihb.general.framework.web;

import com.maihb.general.framework.enums.DataStatus;

/**
 * business.process.result
 * @author simon.wei
 * @param <T>
 */
public class ReturnValue<T> {

    private Integer code;
    private String message;
    private T data;

    private static <T> ReturnValue<T> newInstance(){
        return new ReturnValue<>();
    }

    public static <T> ReturnValue<T> success(){
        return ReturnValue.<T>newInstance().setCode(DataStatus.SUCCESS.getValue()).setMessage(DataStatus.SUCCESS.getName());
    }

    public static <T> ReturnValue<T> success(T data){
        return ReturnValue.<T>newInstance().setCode(DataStatus.SUCCESS.getValue()).setMessage(DataStatus.SUCCESS.getName()).setData(data);
    }

    public static <T> ReturnValue<T> error(){
        return ReturnValue.<T>newInstance().setCode(DataStatus.ERROR.getValue()).setMessage(DataStatus.ERROR.getName());
    }

    public static <T> ReturnValue<T> error(T data){
        return ReturnValue.<T>newInstance().setCode(DataStatus.ERROR.getValue()).setMessage(DataStatus.ERROR.getName()).setData(data);
    }

    public Integer getCode() {
        return code;
    }

    public ReturnValue<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ReturnValue<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ReturnValue<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess(){
        return code.equals(DataStatus.SUCCESS.getValue());
    }

    public boolean isError(){
        return !isSuccess();
    }

}
