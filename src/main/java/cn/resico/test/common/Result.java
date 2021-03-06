package cn.resico.test.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 5952034061105147472L;

    private int code;

    private boolean succeed;

    private String msg;

    private T data;

    private String error;

    private Result(IResultCode resultCode) {
        this(resultCode, resultCode.getMsg(), null);
    }

    private Result(IResultCode resultCode, String msg) {
        this(resultCode, msg, null);
    }

    private Result(IResultCode resultCode, T data) {
        this(resultCode, resultCode.getMsg(), data);
    }

    private Result(IResultCode resultCode, String msg, T data) {
        this(resultCode.getCode(), msg, data);
    }

    private Result(int code, String msg, T data) {
        this.code = code;
        this.succeed = ResultCode.SUCCESS.getCode() == code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功响应消息体
     *
     * @return Result
     */
    public static <T> Result<T> succeed() {
        return new Result<>(ResultCode.SUCCESS);
    }

    /**
     * 成功响应消息体
     *
     * @param data 承载数据
     * @return Result
     */
    public static <T> Result<T> succeed(T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    /**
     * 成功响应消息体
     *
     * @param msg 消息
     * @return Result
     */
    public static <T> Result<T> succeed(String msg) {
        Result result = new Result<>(ResultCode.SUCCESS, msg);
        result.setData(msg);
        return result;
    }

    /**
     * 成功响应消息体
     *
     * @param msg  消息
     * @param data 承载数据
     * @return Result
     */
    public static <T> Result<T> succeed(String msg, T data) {
        return new Result<>(ResultCode.SUCCESS, msg, data);
    }

    /**
     * 失败响应消息体
     *
     * @return Result
     */
    public static <T> Result<T> failed() {
        return new Result<>(ResultCode.FAILURE_SERVICE_EXCEPTION);
    }

    /**
     * 失败响应消息体
     *
     * @param msg 消息
     * @return Result
     */
    public static <T> Result<T> failed(String msg) {
        return new Result<>(ResultCode.FAILURE_SERVICE_EXCEPTION, msg);
    }

    /**
     * 失败响应消息体
     *
     * @param data 承载数据
     * @return Result
     */
    public static <T> Result<T> failed(T data) {
        return new Result<>(ResultCode.FAILURE_SERVICE_EXCEPTION, data);
    }

    /**
     * 失败响应消息体
     *
     * @param msg  消息
     * @param data 承载数据
     * @return Result
     */
    public static <T> Result<T> failed(String msg, T data) {
        return new Result<>(ResultCode.FAILURE_SERVICE_EXCEPTION, msg, data);
    }
    /***
     * @Author: yinyy
     * @Date: 2020/8/13 10:01
     * @MethodName: failed
     * @Description: 自定义code，并返回错误数据
     * @param: msg
     * @param: data
     * @Return: cn.resico.common.api.Result<T>
     **/
    public static <T> Result<T> failed(IResultCode iResultCode,String msg, T data) {
        return new Result<>(iResultCode, msg, data);
    }

    /**
     * 自定义响应消息体
     *
     * @param code 状态码
     * @return Result
     */
    public static <T> Result<T> build(IResultCode code) {
        return new Result<>(code);
    }

    /**
     * 自定义响应消息体
     *
     * @param code 状态码
     * @param msg  消息
     * @return Result
     */
    public static <T> Result<T> build(IResultCode code, String msg) {
        return new Result<>(code, msg);
    }

    /**
     * 自定义响应消息体
     *
     * @param code 状态码
     * @param data 承载数据
     * @return Result
     */
    public static <T> Result<T> build(IResultCode code, T data) {
        return new Result<>(code, data);
    }

    /**
     * 自定义响应消息体
     *
     * @param code 状态码
     * @param msg  消息
     * @param data 承载数据
     * @return Result
     */
    public static <T> Result<T> build(IResultCode code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

}
