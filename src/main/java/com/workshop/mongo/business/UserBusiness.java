package com.workshop.mongo.business;

import com.workshop.mongo.business.exception.ObjectNotFoundException;
import com.workshop.mongo.domain.Post;
import com.workshop.mongo.domain.User;
import com.workshop.mongo.dto.UserDto;
import com.workshop.mongo.repository.PostRepository;
import com.workshop.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserBusiness {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = users.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return usersDto;
    }

    public UserDto findById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        UserDto userDto = new UserDto(user);
        return userDto;
    }

    public User insertUser(User user) {
        return userRepository.insert(user);
    }

    public void deletUser(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User updateUser(UserDto userDto, String id) {
        return userRepository.save(buildUser(userDto, id));
    }

    private User buildUser(UserDto userDto, String id) {
        User user = findById(id).fromDTO();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public List<Post> findPosts(String id) {
        return postRepository.findByAuthorId(id);
    }
}
