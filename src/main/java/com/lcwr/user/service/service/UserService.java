package com.lcwr.user.service.service;

import com.lcwr.user.service.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {



    //  Create user

    User saveUser(User user);

    //get user
    User getUser(String userID);


    //get all user
   List<User> getAllUser();


    //update user
 User updateUser(User user, Integer userId);


    //delete user
 void  deleteUser(Integer userId);




}
