package com.shenzp.springboot.domain;

import lombok.Data;

@Data
public class Resp<T> {

//    @ApiModelProperty(name = "code",value = "响应状态码")
    private Integer code;

//    @ApiModelProperty(name = "msg",value = "提示消息")
    private String msg;

//    @ApiModelProperty(name = "count",value = "总条数")
    private Long count;

//    @ApiModelProperty(name = "data",value = "响应数据")
    private T data;



    public Resp(Integer code, String msg, Long count,T data) {
        this.code = code;
        this.msg = msg;
        this.count=count;
        this.data = data;
    }

    public Resp() {
    }

    public Resp(T data) {
        this.data = data;
    }

    public static<T> Resp<T> ok(T data){
        Resp<T> resp = new Resp<T>(data);
        resp.setCode(0);//操作成功
        resp.setMsg("success");
        return resp;
    }

    public static<T> Resp<T> fail(String  data){
        Resp<T> resp = new Resp<T>();
        resp.setCode(1);//操作失败
        resp.setMsg(data);
        return resp;
    }

    public static<T> Resp<T> pageok(Long count,T data){
        Resp<T> resp = new Resp<T>(data);
        resp.setCode(0);//操作成功
        resp.setMsg("success");
        resp.setCount(count);
        return resp;
    }

    public Resp<T> msg(String msg){
        this.setMsg(msg);
        return this;
    }

    public Resp<T> code(Integer code){
        this.setCode(code);
        return this;
    }
    public Resp<T> count(Long count){
        this.setCount(count);
        return this;
    }

}
