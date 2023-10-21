package com.example.buysell.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long id;
    private String title;
    private String description;
    private int prise;
    private String city;
    private String author;



}
