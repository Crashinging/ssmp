package com.example.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: chenJY
 * @Description: 前后端数据协议
 * @Date: 2022-08-09 15:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {
    // 标志接口是否成功执行
    private Boolean flag;
    // 调用接口返回数据格式
    private Object data;
    // 返回状态信息
    private String msg;

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag,String msg){
        this.flag = flag;
        this.msg = msg;
    }

    public R(String msg){
        this.flag = false;
        this.msg = msg;
    }


}
