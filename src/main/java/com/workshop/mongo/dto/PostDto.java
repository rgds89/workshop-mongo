package com.workshop.mongo.dto;

import com.workshop.mongo.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private List<CommentDto> comments = new ArrayList<>();

    public PostDto(Post post){
        id = post.getId();
        date = post.getDate();
        tile = post.getTitle();
        body = post.getBody();
        author = post.getAuthor();
        comments = post.getComments();
    }
}
