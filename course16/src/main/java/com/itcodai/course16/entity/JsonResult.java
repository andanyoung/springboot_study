package com.itcodai.course16.entity;

/**
 * 统一返回的异常封装实体
 */
public class JsonResult {

    /**
     * 异常码
     */
    protected String code;

    /**
     * 异常信息
     */
    protected String msg;

    public JsonResult() {
        this.code = "200";
        this.msg = "操作成功";
    }

    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

//    public JsonResult(BusinessErrorException ex) {
//        this.code = ex.getCode();
//        this.msg = ex.getMessage();
//    }
//
//    public JsonResult(BusinessMsgEnum msg) {
//        this.code = msg.code();
//        this.msg = msg.msg();
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
