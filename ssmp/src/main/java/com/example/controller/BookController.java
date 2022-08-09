package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.Book;
import com.example.service.IBookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @Author: chenJY
 * @Description: 初版表现层——存在返回数据格式不统一的缺点
 * @Date: 2022-08-09 14:45
 */
//@RestController
@RequestMapping("/books")
public class BookController {

    @Resource
    private IBookService iBookService;

    @GetMapping
    public List<Book> getAll() {
        return iBookService.list(null);
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return iBookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return iBookService.updateById(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return iBookService.removeById(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return iBookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        IPage<Book> page = new Page<>(currentPage,pageSize);
        iBookService.page(page,null);
        return page;
    }
}
