package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.Book;
import com.example.service.IBookService;
import com.example.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
        List<Book> bookList = iBookService.list();
        return new R(true ,bookList);
    }

    @PostMapping
    public R save(@RequestBody Book book){
        Boolean flag = iBookService.save(book);
        // 消息统一处理
        return new R(flag, flag ? "添加成功" : "添加失败");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        Boolean flag = iBookService.updateById(book);
        return new R(flag);
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        Boolean flag = iBookService.removeById(id);
        return new R(flag);
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        Book book = iBookService.getById(id);
        return new R(true,book);
    }

/*    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        IPage<Book> page = iBookService.getPage(currentPage, pageSize);
        // 如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = iBookService.getPage((int)page.getPages(), pageSize);
        }
        return new R(true, page);
    }*/

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> pageBook = iBookService.getPage(currentPage,pageSize,book);
        return new R(null != pageBook ,pageBook);
    }
}
