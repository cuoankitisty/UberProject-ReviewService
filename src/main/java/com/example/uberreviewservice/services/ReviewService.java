package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {
    private  ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*****************");
//        Review r = Review.builder()
//                .content("Amazing content")
//                .rating(5.0)
//                .createdAt(new Date())   //Date object se ye timestamp utha rha h aur yan use kar rha h , lekin ye kaam to hum spring se karwana chahte h , taki user ko manually nhi karna pre
//                .updatedAt(new Date())
//                .build();

        Review r2 = Review.builder()
                .content("Amazing ride quality")
                .rating(5.0)  //ab spring handle kar rha h kyuki @EnableJpaAuditing and @EventListeners annotation laga diye h
                .build();



//        System.out.println(r);
//        reviewRepository.save(r);  //this code executes sql query
        reviewRepository.save(r2);

        List<Review> reviews = reviewRepository.findAll();
        for(Review review : reviews){
            System.out.println(review.getContent());
        }

        reviewRepository.deleteById(2L);
    }

}
