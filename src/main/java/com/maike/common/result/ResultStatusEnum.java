package com.maike.common.result;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultStatusEnum {

//    SUCCESS(200),//成功
//    FAIL(400),//失败
    UNAUTHORIZED(401,"未认证（签名错误）"),//未认证（签名错误）
    NOT_FOUND(404,"接口不存在"),//接口不存在
    INTERNAL_SERVER_ERROR(500,"服务器内部错误"),//服务器内部错误
    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    PARAM_ERROR( 202, "参数不正确"),
    SERVICE_ERROR(203, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    DATA_UPDATE_ERROR(205, "数据版本异常"),
    NO_USER_ID(206,"没有登录，获取菜单权限失败"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),
    CODE_ERROR(210, "验证码错误"),
    CODE_IS_NULL(2101, "验证码为空"),
    CODE_IS_EXPIRE(2102, "验证码已过期"),
    LOGIN_USERNAME_ERROR(211, "账号或密码不正确"),
    LOGIN_DISABLED_ERROR(212, "该用户已被禁用"),
    REGISTER_MOBLE_ERROR(213, "手机号已被使用"),
    LOGIN_MUST(214, "需要登录"),
    LOGIN_ACL(215, "没有权限"),

    URL_ENCODE_ERROR( 216, "URL编码失败"),
    ILLEGAL_CALLBACK_REQUEST_ERROR( 217, "非法回调请求"),
    FETCH_ACCESSTOKEN_FAILD( 218, "获取accessToken失败"),
    FETCH_USERINFO_ERROR( 219, "获取用户信息失败"),
    CAPTCHA_ACCESS_FAIL(220, "获取验证码失败"),
    LOGIN_STATE_EXPIRE( 403, "登录状态失效"),

    PAY_RUN(220, "支付中"),
    CANCEL_ORDER_FAIL(225, "取消订单失败"),
    CANCEL_ORDER_NO(225, "不能取消预约"),

    HOSCODE_EXIST(230, "医院编号已经存在"),
    NUMBER_NO(240, "可预约号不足"),
    TIME_NO(250, "当前时间不可以预约"),

    SIGN_ERROR(300, "签名错误"),
    HOSPITAL_OPEN(310, "医院未开通，暂时不能访问"),
    HOSPITAL_LOCK(320, "医院被锁定，暂时不能访问");

    private final int code;

    private final String msg;

    ResultStatusEnum(int code) {
        this.code = code;
        this.msg = getMsg();
    }

    ResultStatusEnum(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
