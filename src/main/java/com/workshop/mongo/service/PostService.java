package com.workshop.mongo.service;

import com.workshop.mongo.business.PostBusiness;
import com.workshop.mongo.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostBusiness postBusiness;

    public PostDto findById(String id){
        return postBusiness.findById(id);
    }
}
