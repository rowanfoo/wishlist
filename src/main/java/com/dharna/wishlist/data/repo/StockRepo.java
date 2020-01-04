package com.dharna.wishlist.data.repo;

import com.dharna.wishlist.data.entity.CoreStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends JpaRepository<CoreStock, Long>, QuerydslPredicateExecutor<CoreStock> {


}
