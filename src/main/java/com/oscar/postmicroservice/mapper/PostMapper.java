package com.oscar.postmicroservice.mapper;

import com.oscar.postmicroservice.dto.PostDTO;
import com.oscar.postmicroservice.entity.Post;

import java.util.List;

public class PostMapper {

    private PostMapper() {}

    public static PostDTO toDTO(Post post) {
        PostDTO dto = new PostDTO();
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        return dto;
    }

    public static List<PostDTO> toDTOList(List<Post> posts) {
        return posts.stream().map(PostMapper::toDTO).toList();
    }

}
