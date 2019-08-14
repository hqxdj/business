package xdj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import xdj.dao.BookDao;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/7 14:43
 * Copyright (c)   xdj
 */
@Service
public class BookService {
    @Autowired
//    @Qualifier("bookDao")
//    @Resource(name = "bookDao2")
//    @Inject
    private BookDao bookDao;

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
