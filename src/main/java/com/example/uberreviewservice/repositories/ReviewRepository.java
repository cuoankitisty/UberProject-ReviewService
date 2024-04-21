package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


    }

    /*
        spring-data-jpa provides us this JpaRepository jisme bahut se methods h jo help karenge to make ocnnection with databse, bcoz they are implenting queries ,
        hum us repsotory ko extend kar rhe h with our generics , which is type of our entity and id of that entity ,
        and we are extending that interface

        ye ek interface h iska implementation hum bana nhi rhe h, lekin runtime pe spring-data-jpa iska implementtaion banyega , jisme wo sare methhods jo esssential h fir databse communication ke liye unko implemnt karega , aur us implementation class ka object hum review service me constructor injection karke use kar rhe h
     */


//note : class cant extend from an interface, only implements  , only interface can extend form another interface