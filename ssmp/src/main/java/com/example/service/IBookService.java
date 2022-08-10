package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dao.Book;

/**
 * @Author: chenJY
 * @Description: MP快速开发流程
 * @Date: 2022-08-09 14:22
 */
public interface IBookService extends IService<Book> {

    IPage<Book> getPage(int currentPage, int pageSize);

    /*IPage<Book> getPage(int currentPage, int pageSize, Book book);*/

    IPage<Book> getPage(Integer currentPage,Integer pageSize,Book queryBook);
}
