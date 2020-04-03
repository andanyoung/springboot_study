/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName：MsgEnum.java
 * 
 * Description：
 * 
 * History：
 * Version   Author      Date            Operation 
 * 1.0	  lli   2017年8月3日下午2:02:18	       Create	
 */
package com.itcodai.course18.exception;

/**
 * 业务异常提示信息枚举类
 * @author shengwu ni
 */
public enum BusinessMsgEnum {
    /** 参数异常 */
    PARMETER_EXCEPTION("102", "参数异常!"),
    /** 等待超时 */
    SERVICE_TIME_OUT("103", "服务调用超时！"),
    /** 参数过大 */
    PARMETER_BIG_EXCEPTION("102", "输入的图片数量不能超过50张!"),
    /** 500 : 发生异常 */
    UNEXPECTED_EXCEPTION("500", "系统发生异常，请联系管理员！");

    /**
     * 消息码
     */
    private String code;
    /**
     * 消息内容
     */
    private String msg;

    private BusinessMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }

}
