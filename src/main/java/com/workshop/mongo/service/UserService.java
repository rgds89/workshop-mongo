package com.workshop.mongo.service;

import com.workshop.mongo.business.UserBusiness;
import com.workshop.mongo.domain.Post;
import com.workshop.mongo.domain.User;
import com.workshop.mongo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserBusiness userBusiness;

    public List<UserDto> findAllUsers(){
        return userBusiness.findAllUsers();
    }

    public UserDto findById(String id){
        return userBusiness.findById(id);
    }

    public User insertUser(UserDto userDto){
        return userBusiness.insertUser(userDto.fromDTO());
    }

    public void deleteUser(String id){
        userBusiness.deletUser(id);
    }

    public User userUpdate(UserDto userDto, String id){
        return userBusiness.updateUser(userDto, id);
    }

    public List<Post> findPosts(String id){
        return userBusiness.findPosts(id);
    }
}
