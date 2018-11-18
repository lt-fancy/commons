package com.sawallianc.entity;

import lombok.Data;

@Data
public class ResultCode {
    public static final ResultCode SUCCESS = getResultCode(0,"成功");
    public static final ResultCode ERROR = getResultCode(-1,"系统错误");
    public static final ResultCode BLANK_MOBILE = getResultCode(-2,"手机号不能为空");
    public static final ResultCode NOT_REGISTERED = getResultCode(-3,"用户未注册");
    public static final ResultCode WRONG_CHECKCODE = getResultCode(-4,"验证码错误");
    public static final ResultCode SMS_SEND_ERROR = getResultCode(-5,"短信验证码发送失败");
    public static final ResultCode PARAM_ERROR = getResultCode(-6,"参数错误");
    public static final ResultCode PHONE_ALREADY_REGISTERED = getResultCode(-7,"手机号已注册");
    public static final ResultCode USER_BALANCE_NOT_ENOUGH = getResultCode(-8,"用户余额不足");
    public static final ResultCode RACK_HAS_BEEN_DOWN = getResultCode(-9,"该货架已下线");
    public static final ResultCode WRONG_CHECK_CODE = getResultCode(-10,"验证码不正确");
    public static final ResultCode CHECK_CODE_EXPIRED = getResultCode(-11,"验证码已过期");
    public static final ResultCode SEND_CODE_ERROR_HAPPEN = getResultCode(-12,"验证码发送错误，请重试");
    public static final ResultCode SEND_CODE_TOO_FREQUENTLY = getResultCode(-13,"获取验证码太频繁，请1分钟后重试");
	public static final ResultCode ALIPAY_PAY_FAILURE = getResultCode(-14,"支付宝支付失败");
	public static final ResultCode ALIPAY_PRE_ORDER_FAILURE = getResultCode(-15,"预下单失败");
	public static final ResultCode GOODS_DOWN = getResultCode(-16,"所选商品已下架，请刷新页面重新购买");
	public static final ResultCode ALREADY_APPEALED = getResultCode(-17,"已有申诉正在处理中，请勿重复提交");
	public static final ResultCode PRICE_NOT_MATCH_WHILE_PURCHASE = getResultCode(-18,"下单金额和商品金额不一致");
    /**
     * 对于逃单的用户
     */
	public static final ResultCode NEED_ADD_ORDER = getResultCode(-999,"");
    /**
     * 封号
     */
    public static final ResultCode USER_BEING_BANNED = getResultCode(-99,"");
    /**
     * 活动相关
     */
    public static final ResultCode ACTIVITY_IS_OVER = getResultCode(-30,"活动已结束，不能报名参加");
    public static final ResultCode ACTIVITY_IS_NOT_START = getResultCode(-31,"活动未开始，不能报名参加");
    public static final ResultCode ACTIVITY_IS_NOT_PARTICIPATE = getResultCode(-32,"活动不需要报名参加");
    /**
     * 礼品兑换相关
     */
    public static final ResultCode MEMBER_NO_ENOUGH_SCORE = getResultCode(-40,"积分不足，不能兑换");



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
