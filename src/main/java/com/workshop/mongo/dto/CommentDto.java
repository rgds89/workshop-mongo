package com.workshop.mongo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String text;
    private LocalDate date;
    private AuthorDto author;
}
