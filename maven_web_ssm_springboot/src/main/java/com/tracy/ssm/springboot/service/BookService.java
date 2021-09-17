package com.tracy.ssm.springboot.service;


import com.tracy.ssm.springboot.pojo.Book;

import java.util.List;

public interface BookService {
    int addBooke(Book book);
    int deleteById(int bookId);
    int updateBook(Book book);
    Book queryBookById(int bookId);
    List<Book> queryAllBooks();
}
