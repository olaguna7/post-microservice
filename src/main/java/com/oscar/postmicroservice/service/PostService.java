package com.oscar.postmicroservice.service;

import com.oscar.postmicroservice.dto.PostCreateDTO;
import com.oscar.postmicroservice.dto.PostDTO;
import com.oscar.postmicroservice.entity.Post;
import com.oscar.postmicroservice.mapper.PostCreateMapper;
import com.oscar.postmicroservice.mapper.PostMapper;
import com.oscar.postmicroservice.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDTO> findAll() {
        return PostMapper.toDTOList(postRepository.findAll());
    }

    public PostDTO findById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(EntityNotFoundException::new);
        return PostMapper.toDTO(post);
    }

    public PostCreateDTO createPost(PostCreateDTO postCreateDTO) {
        return PostCreateMapper.toDTO(postRepository.save(PostCreateMapper.toEntity(postCreateDTO)));
    }

    public PostCreateDTO updatePost(PostCreateDTO postCreateDTO, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(EntityNotFoundException::new);
        post.setTitle(postCreateDTO.getTitle());
        post.setContent(postCreateDTO.getContent());
        return PostCreateMapper.toDTO((postRepository.save(post)));
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

}
