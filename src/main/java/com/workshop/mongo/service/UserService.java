package com.workshop.mongo.service;

import com.workshop.mongo.business.UserBusiness;
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
}
