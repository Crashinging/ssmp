package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.Book;
import com.example.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: chenJY
 * @Description:
 * @Date: 2022-08-09 13:53
 */
@SpringBootTest
public class BookServiceImplTest {

    @Resource
    BookServiceImpl bookService;

    @Test
    void save() {
        Book book = new Book();
        book.setName("诛仙");
        book.setType("仙侠");
        book.setDescription("天地不仁，以万物为刍狗");
        bookService.save(book);
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(5);
        book.setDescription("高人雅士、王者之痴、匹夫之怒、美人之勇、凡人琐事");
        bookService.update(book);
    }

    @Test
    void delete() {
        bookService.delete(27);
    }

    @Test
    void getById() {
        bookService.getById(5);
    }

    @Test
    void getAll() {
        bookService.getAll();
    }

    @Test
    void getPage() {
        IPage<Book> page = bookService.getPage(2,5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
