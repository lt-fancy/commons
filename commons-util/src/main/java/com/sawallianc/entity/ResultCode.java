package com.sawallianc.entity;

import lombok.Data;

@Data
public class ResultCode {
    public static final ResultCode SUCCESS = getResultCode(0,"成功");
    public static final ResultCode ERROR = getResultCode(-1,"系统错误");
    public static final ResultCode PARAM_ERROR = getResultCode(-6,"参数错误");
    public static final ResultCode BLANK_MOBILE = getResultCode(-2,"手机号不能为空");
    public static final ResultCode NOT_REGISTERED = getResultCode(-3,"用户未注册");
    public static final ResultCode WRONG_CHECKCODE = getResultCode(-4,"验证码错误");
    public static final ResultCode SMS_SEND_ERROR = getResultCode(-5,"短信验证码发送失败");
    public static final ResultCode USER_BALANCE_NOT_ENOUGH = getResultCode(-6,"余额不足");
    public static final ResultCode PHONE_ALREADY_REGISTERED = getResultCode(-7,"手机号已注册");
    private int code;
    private String msg;
    protected ResultCode(){

    }
    private ResultCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
    protected static ResultCode getResultCode(int code, String msg){
        return new ResultCode(code,msg);
    }
}
