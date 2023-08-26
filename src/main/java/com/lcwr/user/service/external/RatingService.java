package com.lcwr.user.service.external;

import com.lcwr.user.service.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name="RATING-SERVICE")
public interface RatingService {

    // get rating




    //add rating
    @PostMapping("/ratings")
    public Rating createRating(Rating values);


    //update rating
    @PutMapping("/rating/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

      @DeleteMapping("/rating/{ratingId}")
    public  void  Delete(@PathVariable("ratingId") String ratingId);

}
