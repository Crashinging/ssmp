package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.Book;
import com.example.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: chenJY
 * @Description:
 * @Date: 2022-08-09 10:44
 */
@SpringBootTest
public class BookMapperTests {

    @Autowired
    private BookMapper mapper;

    @Test
    void testGetById() {
        System.out.println(mapper.selectById(1));
    }

    @Test
    void testGetAll() {
        System.out.println(mapper.selectList(null));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("一念永恒");
        book.setType("仙侠");
        book.setDescription("一念成沧海，一念化桑田。一念斩千魔，一念诛万仙。");
        mapper.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(20);
        book.setDescription("韩老魔的杀人夺宝一路升级的传奇故事");
        mapper.updateById(book);
    }

    @Test
    void testDelet() {
        mapper.deleteById(26);
    }

    /*分页*/
    @Test
    void testGetPage() {
        IPage page = new Page(2,5);
        mapper.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    /*条件*/
    @Test
    void testGetBy() {

        /*  一般写法
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("type","仙");
        mapper.selectList(qw);*/

        /*Lambda写法*/
        String type = "仙";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(type != null, Book::getType, type);
        mapper.selectList(lqw);
    }
}
