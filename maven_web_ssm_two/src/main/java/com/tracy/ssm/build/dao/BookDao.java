package com.tracy.ssm.build.dao;

import com.tracy.ssm.build.pojo.Book;

import java.util.List;

public interface BookDao {
    int addBooke(Book book);
    int deleteById(int bookId);
    int updateBook(Book book);
    Book queryBookById(int bookId);
    List<Book> queryAllBooks();
}
