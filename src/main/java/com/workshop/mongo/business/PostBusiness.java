package com.workshop.mongo.business;

import com.workshop.mongo.business.exception.ObjectNotFoundException;
import com.workshop.mongo.domain.Post;
import com.workshop.mongo.dto.PostDto;
import com.workshop.mongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class PostBusiness {
    @Autowired
    private PostRepository postRepository;

    public PostDto findById(String id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Registro de post não encontrado"));
        PostDto postDto = new PostDto(post);
        return postDto;
    }

    public List<PostDto> findByTitleContainning(String text) {
        List<PostDto> postDtos = new ArrayList<>();
//        List<Post> posts = postRepository.findByTitleContainingIgnoreCase(text);
        List<Post> posts = postRepository.searchTitle(text);

        posts.forEach(x -> {
            PostDto postDto = new PostDto(x);
            postDtos.add(postDto);
        });

        return postDtos;
    }

    public List<PostDto> anySearch(String text, LocalDate minDate, LocalDate maxDate) {
        List<PostDto> postDtos = new ArrayList<>();
        List<Post> posts = postRepository.anySearch(text, minDate, maxDate);

        posts.forEach(x -> {
            PostDto postDto = new PostDto(x);
            postDtos.add(postDto);
        });

        return postDtos;
    }
}
