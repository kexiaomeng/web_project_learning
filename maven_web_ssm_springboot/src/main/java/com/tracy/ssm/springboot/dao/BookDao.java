package com.tracy.ssm.springboot.dao;


import com.tracy.ssm.springboot.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface BookDao {
    int addBooke(Book book);
    int deleteById(int bookId);
    int updateBook(Book book);
    Book queryBookById(int bookId);
    List<Book> queryAllBooks();
}
