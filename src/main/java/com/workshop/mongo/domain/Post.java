package com.workshop.mongo.domain;

import com.workshop.mongo.dto.AuthorDto;
import com.workshop.mongo.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Document
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private LocalDate date;
    private String tile;
    private String body;
    private AuthorDto author;
    private List<CommentDto> comments = new ArrayList<>();

    public Post(String id, LocalDate date, String tile, String body, AuthorDto author) {
        this.id = id;
        this.date = date;
        this.tile = tile;
        this.body = body;
        this.author = author;
    }
}
