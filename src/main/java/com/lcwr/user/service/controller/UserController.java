package com.lcwr.user.service.controller;


import com.lcwr.user.service.entity.User;
import com.lcwr.user.service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);


// create user
    @PostMapping
     public ResponseEntity<User> createUser(@RequestBody User user)
     {
        User user1=   userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

     }

     int retry_count=0;
     // get single user
@GetMapping("/{userId}")
// @CircuitBreaker(name ="ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
@Retry(name="ratingHotelService" , fallbackMethod ="ratingHotelFallback" )
public  ResponseEntity<User> getSingleUser( @PathVariable  String userId){

    logger.info ("retry method times :{}",retry_count);
    retry_count ++;
    User user=userService.getUser(userId);
                  return ResponseEntity.ok(user);
}

public  ResponseEntity<User> ratingHotelFallback(String userId, Exception ex)
{

 //  logger.info("Fallback is executed because service is down "+ex.getMessage());

   User user= User.builder().email("Dummy@gmail.com").name("Dummy").userId("1234").about("this user is created because dummy file is needed").build();
    return  new ResponseEntity<>(user, HttpStatus.OK);

}



    // get all user

    @GetMapping
    public ResponseEntity<List<User>> getAllUser()
    {
                 List<User> allUser =    userService.getAllUser();
                 return ResponseEntity.ok(allUser);
    }








}
