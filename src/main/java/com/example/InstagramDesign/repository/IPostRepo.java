package com.example.InstagramDesign.repository;

import com.example.InstagramDesign.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepo extends CrudRepository<Post,Integer> {
}
