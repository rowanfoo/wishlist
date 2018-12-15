package com.dharna.wishlist.controller.data;

import com.dharna.wishlist.data.entity.QWishlist;
import com.dharna.wishlist.data.entity.Wishlist;
import com.dharna.wishlist.data.repo.WishlistRepo;
import org.glassfish.jersey.internal.guava.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired WishlistRepo wishlistRepo;

    @PutMapping("/")
    public void  insert (@RequestBody Wishlist wishlist){
        System.out.println("----insert-------------" + wishlist);
 //       wishlistRepo.save(wishlist);
    }


    @GetMapping()
    public Iterable<Wishlist> getbywishname(@PathVariable String name){

      return   wishlistRepo.findAll(QWishlist.wishlist1.wishlist.eq(name));

    }

    @GetMapping("/wishcategory")
    public Iterable<Wishlist>  getwishlistcategory(String category){

        Iterable<Wishlist> arr =   wishlistRepo.findAll(QWishlist.wishlist1.wishlist.eq(category));

        arr.forEach((a)->{

            System.out.println("-----" + a);
        });

       // return Lists.newArrayList(arr) ;
    return arr;
    }



//
//
//
//    @CrossOrigin
//    @RequestMapping("/stocks")
//    public Iterable<CoreData> getDataStockDate(@RequestParam String stocks, @RequestParam String date ){
//
//        System.out.println("--------------getDataStockDate ------------" + stocks);
//
//        String arr[] = stocks.split(",");
//
//
//        return coreDataService.getDataAllStock(arr,date );
//    }
//
//
//
//
//    @CrossOrigin
//    @RequestMapping("/clearcache")
//    public String  clearCache(){
//        coreDataService.clearcache();
//        return "done";
//    }






}
