package com.workshop.mongo.business;

import com.workshop.mongo.business.exception.ObjectNotFoundException;
import com.workshop.mongo.domain.User;
import com.workshop.mongo.dto.UserDto;
import com.workshop.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserBusiness {
    @Autowired
    private UserRepository userRepository;

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
}
