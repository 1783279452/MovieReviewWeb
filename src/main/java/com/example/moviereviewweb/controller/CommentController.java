package com.example.moviereviewweb.controller;

import com.example.moviereviewweb.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;
}
