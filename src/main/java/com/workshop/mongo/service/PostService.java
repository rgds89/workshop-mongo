package com.workshop.mongo.service;

import com.workshop.mongo.business.PostBusiness;

import com.workshop.mongo.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostBusiness postBusiness;

    public PostDto findById(String id){
        return postBusiness.findById(id);
    }

    public List<PostDto> findByTitleContainning(String text){
        return  postBusiness.findByTitleContainning(text);
    }

    public List<PostDto> anySearch(String text, LocalDate minDate, LocalDate maxDate){
        return  postBusiness.anySearch(text, minDate, maxDate);
    }
}
