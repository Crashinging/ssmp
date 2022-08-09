package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.Book;
import com.example.service.IBookService;
import com.example.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: chenJY
 * @Description:
 * @Date: 2022-08-09 15:32
 */
@RestController
@RequestMapping("/books")
public class BookControllerPro {
    @Resource
    private IBookService iBookService;

    @GetMapping
    public R getAll() {
        return new R(true, iBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book){
        return new R(iBookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(iBookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(iBookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, iBookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        IPage<Book> page = new Page<>(currentPage,pageSize);
        return new R(true, iBookService.page(page,null));
    }
}
