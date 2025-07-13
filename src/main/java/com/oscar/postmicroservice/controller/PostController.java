package com.oscar.postmicroservice.controller;

import com.oscar.postmicroservice.service.PostService;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

}
