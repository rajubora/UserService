package com.lcwr.user.service;

import com.lcwr.user.service.entity.Rating;
import com.lcwr.user.service.external.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

@Autowired
	 private RatingService ratingService;
	@Test
	void contextLoads() {

	}



}
