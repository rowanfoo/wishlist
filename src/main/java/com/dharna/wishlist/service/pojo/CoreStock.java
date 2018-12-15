package com.dharna.wishlist.service.pojo;


import lombok.Data;
import org.hibernate.annotations.NaturalId;
@Data
public class CoreStock {
    private Long id;
    private String code;
    private java.sql.Date date;
    private String name;
    private String descp;
    private Long shares;
    private Long marketcap;
    private String consequtivelow;
    private String category;
    private String subcategory;
    private String top;
    private String notes1;
    private String notes2;
    private String reason;
    private String moat;
    private String fundnotes;
    private Double buytrigger;
    private String wishlist;
    private String trend;
    private Double alertprice;
    private Double normandyprice;
    private String normandynotes;
    private String fydate;
    private String technicalnotes;
    private String montlynotes;
    private String weeklynotes;
    private String dailynotes;
    private Double stoploss;
    private String stoplossnotes;
    private String whenbuy;
    private Double whenbuyprice;
    private String easychange;
    private Double keysupportprice;
    private String keysupportpricenotes;
    private String defendkeynotes;
    private Double defendkeyprice;
    private String nope;
    private String news;
    private String chart;
    private String stagegrowth;
    private String research;
    private String researchcat;
    private String onenotes;
    private String aindex;
    private String delisted;
    private Double yearhigh;
    private Double pe;
    private Double eps;
    private Double yearlow;
    private Double dividend;
    private Long dailyvol;
    private Double yearchangepercentage;
    private String tolook;
    private String tags;


    public  CoreStock(){}



}
