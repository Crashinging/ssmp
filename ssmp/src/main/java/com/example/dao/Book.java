package com.example.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: chenJY
 * @Description:
 * @Date: 2022-08-09 9:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
