package com.workshop.mongo.resources;

import com.workshop.mongo.dto.PostDto;
import com.workshop.mongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/posts" )
public class PostResources {
    @Autowired
    private PostService postService;

    @RequestMapping(value="/{id}")
    public ResponseEntity<PostDto> findById(@PathVariable String id){
        return ResponseEntity.ok().body(postService.findById(id));
    }
}
