package com.workshop.mongo.dto;

import com.workshop.mongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String email;

    public UserDto (User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }
}
