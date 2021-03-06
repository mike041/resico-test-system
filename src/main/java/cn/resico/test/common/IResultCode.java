package cn.resico.test.common;

import java.io.Serializable;

public interface IResultCode extends Serializable {
    /**
     * 状态码
     *
     * @return code
     */
    default Integer getCode() {
        return 10000;
    }

    /**
     * 消息描述
     *
     * @return msg
     */
    default String getMsg() {
        return "成功";
    }
}
