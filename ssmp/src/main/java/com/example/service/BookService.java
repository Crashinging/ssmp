package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.dao.Book;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * @Author: chenJY
 * @Description: 常规流程
 * @Date: 2022-08-09 13:43
 */
public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(int currentPage, int pageSize);

}
