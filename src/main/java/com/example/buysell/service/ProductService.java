package com.example.buysell.service;

import com.example.buysell.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;
    {
        products.add(new Product(++ID,"PS5","description",40000,"Moscov","Ivan"));
        products.add(new Product(++ID,"PS4","description",30000,"Moscov","Ilia"));
        products.add(new Product(++ID,"PS3","description",10000,"Moscov","Vika"));
    }
    public List<Product> list(){return products;}
    public void saveProduct(Product product){
        product.setId(++ID);
        products.add(product);
    }
    public void deleteProduct(Long id){
        products.removeIf(products -> products.getId() == id);
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId() == id) return product;
        }
        return null;
    }
}
