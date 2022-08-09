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

    public R(Boolean flag) {
        this.flag = flag;
    }
}
