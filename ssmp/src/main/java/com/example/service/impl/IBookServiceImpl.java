package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.Book;
import com.example.mapper.BookMapper;
import com.example.service.IBookService;
import org.springframework.stereotype.Service;

/**
 * @Author: chenJY
 * @Description: MP快速开发流程
 * @Date: 2022-08-09 14:25
 */
@Service
public class IBookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
}
