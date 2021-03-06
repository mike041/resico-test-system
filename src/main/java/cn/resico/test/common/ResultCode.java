package cn.resico.test.common;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.Map;

public enum ResultCode implements IResultCode {
    /**
     * 常见状态码
     */
    SUCCESS(10000, "成功"),
    FAILURE_SERVICE_EXCEPTION(10001, "业务错误"),
    FAILURE_EXCEPTION(10002, "系统错误"),
    PARAM_VALID_ERROR(10100, "参数校验失败"),
    PASSWORD_ERROR(10200, "密码必须修改"),
    VERSION_ERROR(10300, "接口版本升级"),

    /**
     * 框架常见请求状态
     */
    MSG_NOT_READABLE(10400, "消息不可读"),
    UN_AUTHORIZED(10401, "登录超时，请重新登录"),
    TOKEN_EXPIRED(10402, "登录超时，请重新登录"),
    REQ_REJECT(10403, "非法请求"),
    NOT_FOUND(10404, "未找到请求资源"),
    METHOD_NOT_SUPPORTED(10405, "不允许使用该请求方法"),
    TOKEN_DELETE(10406, "用戶在其他地方登录"),
    TOKEN_LOCKED(10407, "用户已锁定"),
    MEDIA_TYPE_NOT_SUPPORTED(10415, "不支持的媒体类型"),
    INTERNAL_SERVER_ERROR(10500, "服务繁忙"),

    //企业入驻 - 业务异常
    SETTLE_NO_PROTOCOL(11001, "该客户暂未上传合作协议"),
    SETTLE_PROTOCOL_AUDIT(11002, "该客户存在暂未审核完成的合作协议或补充协议"),
    SETTLE_PROTOCOL_COMPLETE(11003, "该客户合作协议条款已履行完成"),

    INVALID_VOUCHER_DETAILS(12000, "非法的完税凭证明细信息"),

    FLOW_EXPIRED(13000, "流程任务过期"),

    /**
     * 优税猫异常
     */
    //开票客户信息是否完整状态码
    GENERAL_NOT_COMPLETED(10001001, "请先添加一般纳税人资质/客户详细信息"),
    SMALL_NOT_COMPLETED(10001002, "请先添加客户详细信息"),
    //框架合同无结算清单
    FRAME_NO_VOUCHER_BILL(10001003, "所选合同没有可用的结算清单，请先添加结算清单"),


    /**
     * 微信小程序状态码
     */
    WX_APP_UNAUTHORIZEDEXCEPTION(19000, "微信小程序未授权手机号，无法注册!");

    private final Integer code;
    private final String msg;

    ResultCode(final Integer code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    @JsonCreator
    public static ResultCode fromValue(Object code) {
        if (code instanceof Integer) {
            return Arrays.stream(ResultCode.values())
                    .filter(codeEnum -> codeEnum.getCode().equals(code))
                    .findFirst().orElse(null);
        } else if (code instanceof Map) {
            Map baseEnum = (Map) code;
            return Arrays.stream(ResultCode.values())
                    .filter(codeEnum -> codeEnum.getCode().equals(baseEnum.get("code")))
                    .findFirst().orElse(null);
        }
        return null;
    }


    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
