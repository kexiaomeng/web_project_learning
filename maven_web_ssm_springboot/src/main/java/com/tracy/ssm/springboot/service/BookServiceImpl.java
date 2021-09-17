package com.tracy.ssm.springboot.service;


import com.tracy.ssm.springboot.dao.BookDao;
import com.tracy.ssm.springboot.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Override
    public int addBooke(Book book) {
        return bookDao.addBooke(book);
    }

    @Override
    public int deleteById(int bookId) {
        return bookDao.deleteById(bookId);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(int bookId) {
        return bookDao.queryBookById(bookId);
    }

    @Override
    public List<Book> queryAllBooks() {
        return bookDao.queryAllBooks();
    }
}
