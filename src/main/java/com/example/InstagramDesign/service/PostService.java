package com.example.InstagramDesign.service;

import com.example.InstagramDesign.model.Post;
import com.example.InstagramDesign.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {
    @Autowired
    IPostRepo pr;

    public void savepost(Post post) {
        pr.save(post);
    }

    public List<Post> getpost() {
        return (List<Post>) pr.findAll();
    }
}
