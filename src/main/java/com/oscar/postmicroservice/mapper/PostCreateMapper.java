package com.oscar.postmicroservice.mapper;

import com.oscar.postmicroservice.dto.PostCreateDTO;
import com.oscar.postmicroservice.entity.Post;

public class PostCreateMapper {

    private PostCreateMapper() {}

    public static PostCreateDTO toDTO(Post post) {
        PostCreateDTO dto = new PostCreateDTO();
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        return dto;
    }

    public static Post toEntity(PostCreateDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        return post;
    }

}
