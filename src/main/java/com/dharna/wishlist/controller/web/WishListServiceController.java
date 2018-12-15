package com.dharna.wishlist.controller.web;

import com.dharna.wishlist.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class WishListServiceController {
@Autowired WishlistService wishlistService ;
    @GetMapping("/wishlistcategorys")
    public List<String> getwishlistcategory(){
        return wishlistService.findWishlistCategory();

    }

    @GetMapping("/allcodes")
    public List<String> getallcodes(){
        return wishlistService.getallstockcodes();

    }






}
