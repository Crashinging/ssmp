package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.Book;
import com.example.mapper.BookMapper;
import com.example.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: chenJY
 * @Description: 常规流程
 * @Date: 2022-08-09 13:45
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper mapper;

    @Override
    public Boolean save(Book book) {
        return mapper.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return mapper.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return mapper.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return mapper.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return mapper.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        mapper.selectPage(page, null);
        return page;
    }
}
