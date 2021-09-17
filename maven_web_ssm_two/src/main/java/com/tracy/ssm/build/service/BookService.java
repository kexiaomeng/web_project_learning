package com.tracy.ssm.build.service;

import com.tracy.ssm.build.pojo.Book;

import java.util.List;

public interface BookService {
    int addBooke(Book book);
    int deleteById(int bookId);
    int updateBook(Book book);
    Book queryBookById(int bookId);
    List<Book> queryAllBooks();
}
