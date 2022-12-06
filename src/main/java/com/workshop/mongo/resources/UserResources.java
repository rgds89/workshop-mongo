package com.workshop.mongo.resources;

import com.workshop.mongo.domain.User;
import com.workshop.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
//        User maria = new User("1", "Maria Silva", "maria@gmail.com");
//        User alex = new User("2", "Alex Green", "alex@gmail.com");

        List<User> users = new ArrayList<>();
        users.addAll(userService.findAllUsers());
        return ResponseEntity.ok().body(users);
    }
}
