package com.dharna.wishlist.data.repo;

import com.dharna.wishlist.data.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface WishlistRepo extends JpaRepository<Wishlist, Long>, QuerydslPredicateExecutor<Wishlist> {

}
