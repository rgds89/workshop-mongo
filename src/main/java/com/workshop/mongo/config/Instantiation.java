package com.workshop.mongo.config;

import com.workshop.mongo.domain.Post;
import com.workshop.mongo.domain.User;
import com.workshop.mongo.dto.AuthorDto;
import com.workshop.mongo.dto.CommentDto;
import com.workshop.mongo.repository.PostRepository;
import com.workshop.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@email.com");
        User alex = new User(null, "Alex Green", "alex@email.com");
        User bob = new User(null, "Bob Grey", "bobg@email.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.now(), "Partiu Viagem", "Vou viajar para São Paulo, abraços", new AuthorDto(maria));
        Post post2 = new Post(null, LocalDate.now().plusDays(2L),"Bom dia", "Acordei Feliz hoje!", new AuthorDto(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

        CommentDto comment1 = new CommentDto("Boa Viagem", LocalDate.now(), new AuthorDto(alex));
        CommentDto comment2 = new CommentDto("Aproveite bastante", LocalDate.now().plusDays(1L), new AuthorDto(bob));
        CommentDto comment3 = new CommentDto("Aproveite o dia", LocalDate.now().plusDays(2l), new AuthorDto(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);
        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
