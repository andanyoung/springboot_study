/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName：BusinessErrorException.java
 * 
 * Description：
 * 
 * History：
 * Version   Author      Date            Operation 
 * 1.0	  lli   2017年8月2日下午5:30:56	       Create	
 */
package com.itcodai.course08.exception;

/**
 * 自定义业务异常
 * @author shengwu ni
 */
public class BusinessErrorException extends RuntimeException {

    private static final long serialVersionUID = -7480022450501760611L;

    /**
     * 异常码
     */
    private String code;

    /**
     * 异常提示信息
     */
    private String message;

    public BusinessErrorException(BusinessMsgEnum businessMsgEnum) {
        this.code = businessMsgEnum.code();
        this.message = businessMsgEnum.msg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
