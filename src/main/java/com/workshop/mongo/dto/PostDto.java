package com.workshop.mongo.dto;

import com.workshop.mongo.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class PostDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private LocalDate date;
    private String tile;
    private String body;
    private AuthorDto author;

    public PostDto(Post post){
        id = post.getId();
        date = post.getDate();
        tile = post.getTile();
        body = post.getBody();
        author = post.getAuthor();
    }
}
