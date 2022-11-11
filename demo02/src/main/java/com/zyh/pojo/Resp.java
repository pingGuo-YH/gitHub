package com.zyh.pojo;

import lombok.Data;

@Data
public class Resp<E> {
    private String code;
    private String message;
    private E body;

    Resp(String code,String message,E body){
        this.code = code;
        this.message = message;
        this.body = body;
    }

    /**
     * 上传成功
     * @param body
     * @param <E>
     * @return
     */
    public static <E> Resp<E> success(E body){
        return new Resp("200","",body);
    }

    /**
     * 上传失败
     * @param code
     * @param message
     * @param <E>
     * @return
     */
    public static <E> Resp<E> fail(String code,String message){
        return new Resp(code,message,null);
    }
}
