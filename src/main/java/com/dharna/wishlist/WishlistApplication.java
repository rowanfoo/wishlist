package com.dharna.wishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class WishlistApplication {

    public static void main(String[] args) {
        SpringApplication.run(WishlistApplication.class, args);
    }
}
