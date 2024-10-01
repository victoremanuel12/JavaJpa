package com.boostore.jpa.controller;

import com.boostore.jpa.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookStore/book")
public class BookController {
    @Autowired
    private BookServices bookServices;

}
