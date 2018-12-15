package com.dharna.wishlist.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Wishlist {
    @Id
    private String wishlist;
    private String code;




}
