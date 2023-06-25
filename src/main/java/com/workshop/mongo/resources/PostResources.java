package com.workshop.mongo.resources;

import com.workshop.mongo.dto.PostDto;
import com.workshop.mongo.resources.util.URL;
import com.workshop.mongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PostDto> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(postService.findById(id));
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<PostDto>> findByTitleContaining(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        return ResponseEntity.ok().body(postService.findByTitleContainning(text));
    }

    @RequestMapping(value = "/anysearch", method = RequestMethod.GET)
    public ResponseEntity<List<PostDto>> findByTitleContaining(@RequestParam(value = "text", defaultValue = "") String text, @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                               @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        LocalDate min = URL.convertDate(minDate, LocalDate.now());
        LocalDate max = URL.convertDate(maxDate, LocalDate.now());
        return ResponseEntity.ok().body(postService.anySearch(text, min, max.plusDays(1)));
    }
}
