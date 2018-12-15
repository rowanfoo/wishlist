package com.dharna.wishlist;

import com.dharna.wishlist.service.WishlistService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WishlistApplicationTests {
@Autowired
    WishlistService wishlistService;
    @Test
    public void contextLoads() {
        List<String> stk;
        stk = wishlistService.findWishlistCategory();

        stk.forEach((a)->{
            System.out.println("------stk----"+a);
        });



        //stk = wishlistService.findWishlistCategory();

//        stk = wishlistService.getallstockcodes();
  //      stk = wishlistService.getallstockcodes();
//        stk.forEach((a)->{
//            System.out.println("------xxx----"+a);
//        });



    }

}
