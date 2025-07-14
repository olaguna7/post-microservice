package com.oscar.postmicroservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostCreateDTO {
    private String title;
    private String content;
}
