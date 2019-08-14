package xdj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import xdj.service.BookService;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/7 14:42
 * Copyright (c)   xdj
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
