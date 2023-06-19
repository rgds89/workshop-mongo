package com.workshop.mongo.dto;

import com.workshop.mongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    public AuthorDto(User user) {
        id = user.getId();
        name = user.getName();
    }
}
