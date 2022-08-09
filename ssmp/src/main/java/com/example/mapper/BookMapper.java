package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.dao.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: chenJY
 * @Description:
 * @Date: 2022-08-09 10:38
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
