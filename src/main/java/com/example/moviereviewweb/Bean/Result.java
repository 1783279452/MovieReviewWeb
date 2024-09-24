package com.example.moviereviewweb.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {//响应类
    private Integer code;//响应码，1 代表成功; 0 代表失败
    private String msg;  //响应信息 描述字符串
    private Object data; //返回的数据

    /*
    使用方法例public Result get()
    返回数据格式return Result.success(xxxx);
    */

    //增删改 成功响应
    public static Result success(){
        return new Result(200,"success",null);
    }
    //查询 成功响应
    public static Result success(Object data){
        return new Result(200,"success",data);
    }
    //失败响应
    public static Result error(String msg){
        return new Result(500,msg,null);
    }
}
