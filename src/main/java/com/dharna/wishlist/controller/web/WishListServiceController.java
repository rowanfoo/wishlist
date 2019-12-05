package com.dharna.wishlist.controller.web;

import com.dharna.wishlist.data.entity.QWishlist;
import com.dharna.wishlist.data.entity.Wishlist;
import com.dharna.wishlist.data.repo.WishlistRepo;
import com.dharna.wishlist.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class WishListServiceController {
    @Autowired
    WishlistService wishlistService;
    @Autowired
    WishlistRepo wishlistRepo;

    @GetMapping("/wishlistcategorys")
    public List<String> getwishlistcategory() {
        return wishlistService.findWishlistCategory();

    }

    @GetMapping("/allcodes")
    public List<String> getallcodes() {
        return wishlistService.getallstockcodes();

    }

    @GetMapping("/wishcategorycodes")
    public Iterable<Wishlist> getwishlistcategory(String category) {

        Iterable<Wishlist> arr = wishlistRepo.findAll(QWishlist.wishlist.category.eq(category));

        arr.forEach((a) -> {

            System.out.println("-----" + a);
        });

        // return Lists.newArrayList(arr) ;
        return arr;
    }


}
