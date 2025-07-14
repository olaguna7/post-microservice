package com.oscar.postmicroservice.controller;

import com.oscar.postmicroservice.dto.PostCreateDTO;
import com.oscar.postmicroservice.dto.PostDTO;
import com.oscar.postmicroservice.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{postId}")
    public PostDTO getPostById(@PathVariable("postId") Long postId) {
        return postService.findById(postId);
    }

    @PostMapping
    public ResponseEntity<PostCreateDTO> createPost(@RequestBody PostCreateDTO postDTO) {
        PostCreateDTO post = postService.createPost(postDTO);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public PostCreateDTO updatePost(@RequestBody PostCreateDTO postDTO, @PathVariable("postId") Long postId) {
        return postService.updatePost(postDTO, postId);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }

}
