package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository implements CommandLineRunner {
    /*
        we are not creating any object so that we can call this run method , we are simply implementing this interface , to jaise main method load ho jata h automatically
        waise hi jab ye class load hoga to ye method apne app load ho jaaeyga , abhi hum controller banake load nhi karna chahte , just to make it simple

     */

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*********");
        Review r = Review.builder()
                .content("Amazing content")
                .rating(5.0)
                .build();  //creating a plain java object

        //lekin jab oject banaye to entry table me store kyu ni hua?
        //bcoz abhi repository databse se connection hi nhi kar rha h , to ya to tum manul queries likh ke insert karo , ya methods use karo hibernate ka , lekin we want ki spring data jpa ye kare humare luye
        //for that we have to do some more manual effort
    }
}

//note : class cant extend from an interface, only implements  , only interface can extend form another interface