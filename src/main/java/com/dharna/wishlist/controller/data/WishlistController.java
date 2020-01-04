package com.dharna.wishlist.controller.data;

import com.dharna.wishlist.data.entity.QCoreStock;
import com.dharna.wishlist.data.entity.QWishlist;
import com.dharna.wishlist.data.entity.Wishlist;
import com.dharna.wishlist.data.repo.StockRepo;
import com.dharna.wishlist.data.repo.WishlistRepo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    WishlistRepo wishlistRepo;
    @Autowired
    StockRepo stockRepo;

    @PutMapping("/")
    public ResponseEntity<JsonNode> insert(@RequestBody Wishlist wishlist) {
        System.out.println("----insert-------------" + wishlist);

        Optional<Wishlist> wish = wishlistRepo.findOne(QWishlist.wishlist.category.eq(wishlist.category));
//        wish.get()
        String notfoundcodes = isStockinDb(wishlist.getCode());
        System.out.println("---------not found----------------" + notfoundcodes);

        if (notfoundcodes != null) {

            return new ResponseEntity<>(jsoncodes(notfoundcodes), HttpStatus.FOUND);
        }
        System.out.println("---------not found----------------" + wish);
        if (wish.isPresent()) {
            Wishlist twish = wish.get();
            twish.setCode(wishlist.getCode());
            wishlistRepo.save(twish);

        } else {
            wishlistRepo.save(wishlist);

        }
        return new ResponseEntity<>(jsoncodes(wishlist.getCode()), HttpStatus.OK);
    }

    private JsonNode jsoncodes(String codes) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.createObjectNode();
        ((ObjectNode) node).put("code", codes);
        return node;


    }


    private String isStockinDb(String code) {
//        String alpha = "BHP.AX,TGF.AX,RIO.AX";

        //Remove whitespace and split by comma
        List<String> cs = Arrays.asList(code.split("\\s*,\\s*"));


//        List<String> cs = new ArrayList<>();
//        cs.add("BHP.AX");
//        cs.add("TGF.AX");

        List<String> diff = new ArrayList<>();

        //Iterable<CoreStock> it = stockRepo.findAll(QCoreStock.coreStock.code.in(cs));
//        List<CoreStock> stooks =
        List<String> stooks = Lists.newArrayList(stockRepo.findAll(QCoreStock.coreStock.code.in(cs))).stream().map(a -> {
            return a.code;
        }).collect(Collectors.toList());


        cs.forEach(a -> {
            //  System.out.println("--" + a);
            if (!stooks.contains(a)) diff.add(a);
        });


        diff.forEach(s -> System.out.println("----->" + s));

        if (diff.isEmpty()) return null;

        return String.join(",", diff);

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
