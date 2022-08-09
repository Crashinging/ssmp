package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.Book;
import com.example.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: chenJY
 * @Description:
 * @Date: 2022-08-09 14:27
 */
@SpringBootTest
class IBookServiceImplTest {
    @Resource
    private IBookServiceImpl iBookService;

    @Test
    void testGetById() {
        System.out.println(iBookService.getById(1));
    }

    @Test
    void testGetAll() {
        System.out.println(iBookService.list(null));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("重生之超级战舰");
        book.setType("科幻");
        book.setDescription("探索宇宙之中的奥秘，和系外行星，各种恒星，白矮星，中子星，黑洞，类星体等进行亲密接触，和各种宇宙文明进行血腥厮杀，探寻被隐藏在重重迷雾之后的宇宙真理……");
        iBookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(20);
        book.setDescription("韩老魔的杀人夺宝一路升级的传奇故事");
        iBookService.updateById(book);
    }

    @Test
    void testDelet() {
        iBookService.removeById(26);
    }

    /*分页*/
    @Test
    void testGetPage() {
        IPage<Book> page = new Page<>(2,5);
        iBookService.page(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
