package com.dharna.wishlist.service;

import com.dharna.wishlist.data.entity.QWishlist;
import com.dharna.wishlist.data.repo.WishlistRepo;
import com.dharna.wishlist.service.pojo.CoreStock;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService {

    @PersistenceContext
    private EntityManager em;


    @Autowired
    WishlistRepo repo;
    @Cacheable("wishlistcategory")
    public List<String> findWishlistCategory(){

//        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//
//        List<String> stks =  queryFactory.select(QWishlist.wishlist1.wishlist).
//                from(QWishlist.wishlist1)
//                .distinct()
//                .fetch();
//        return  stks;
//
     ArrayList<String> arr = new ArrayList<>();
      repo.findAll().forEach((a)->{

          arr.add(a.getWishlist()  );

      });
          return arr;

    }
    @Cacheable("wishlistcodes")
    public  List<String> getallstockcodes(){
        System.out.println("-------getallstockcodes---------");

        String uri ="http://192.168.0.8:9000/stock/all";
        RestTemplate restTemplate =new RestTemplate();
        CoreStock result[] = restTemplate.getForObject(uri, CoreStock[].class);
        ArrayList<String> arr  = new ArrayList<>();
        for (CoreStock coreStock : result) {
          arr.add(coreStock.getCode());
        }
        return arr;



    }




}
