package com.oscar.postmicroservice.service;

import com.oscar.postmicroservice.dto.PostDTO;
import com.oscar.postmicroservice.mapper.PostMapper;
import com.oscar.postmicroservice.repository.PostRepository;
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

}
