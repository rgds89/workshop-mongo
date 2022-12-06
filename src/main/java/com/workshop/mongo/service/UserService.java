package com.workshop.mongo.service;

import com.workshop.mongo.business.UserBusiness;
import com.workshop.mongo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserBusiness userBusiness;

    public List<User> findAllUsers(){
        return userBusiness.findAllUsers();
    }
}
