package com.workshop.mongo.resources;

import com.workshop.mongo.domain.User;
import com.workshop.mongo.dto.UserDto;
import com.workshop.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> users = new ArrayList<>();
        users.addAll(userService.findAllUsers());
        return ResponseEntity.ok().body(users);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody UserDto userDto) {
        User user = userService.insertUser(userDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return  ResponseEntity.noContent().build();
    }
}
