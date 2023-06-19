package com.workshop.mongo.business;

import com.workshop.mongo.business.exception.ObjectNotFoundException;
import com.workshop.mongo.domain.Post;
import com.workshop.mongo.dto.PostDto;
import com.workshop.mongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostBusiness {
    @Autowired
    private PostRepository postRepository;

    public PostDto findById(String id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Registro de post não encontrado"));
        PostDto postDto = new PostDto(post);
        return postDto;
    }
}
