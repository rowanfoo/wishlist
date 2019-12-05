package com.dharna.wishlist.controller.data;

import com.dharna.wishlist.data.entity.QWishlist;
import com.dharna.wishlist.data.entity.Wishlist;
import com.dharna.wishlist.data.repo.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    WishlistRepo wishlistRepo;

    @PutMapping("/")
    public void insert(@RequestBody Wishlist wishlist) {
        System.out.println("----insert-------------" + wishlist);

        Optional<Wishlist> wish = wishlistRepo.findOne(QWishlist.wishlist.category.eq(wishlist.category));
//        wish.get()


        if (wish.isPresent()) {
            Wishlist twish = wish.get();
            twish.setCode(wishlist.getCode());
            wishlistRepo.save(twish);

        } else {
            wishlistRepo.save(wishlist);

        }

    }


    @GetMapping()
    public Iterable<Wishlist> getbywishname(@PathVariable String name) {

        return wishlistRepo.findAll(QWishlist.wishlist.category.eq(name));

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
