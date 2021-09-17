package com.tracy.ssm.springboot.controller;



import com.tracy.ssm.springboot.pojo.Book;
import com.tracy.ssm.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

//    @RequestMapping("/allbook")
//    public List<Book> getAllBook() {
//        return bookService.queryAllBooks();
//    }
    @RequestMapping("/allbook.do")
    public String getAllBook(Model model) {

        List<Book> books = bookService.queryAllBooks();
        model.addAttribute("books",books);
        return "queryAllBooks";
    }
}
