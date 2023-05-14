package com.example.InstagramDesign.repository;

import com.example.InstagramDesign.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends CrudRepository<User,Integer> {
    User findFirstByEmail(String userEmail);

    @Modifying
    @Query(value = "update user set email= :email where id= :id",nativeQuery = true)
    void updateUser(Integer id, String email);

}
