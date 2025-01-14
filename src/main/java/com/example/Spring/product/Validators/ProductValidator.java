package com.example.Spring.product.Validators;

import com.example.Spring.product.Exceptions.ProductNotValidException;
import com.example.Spring.product.Model.Product;
import io.micrometer.common.util.StringUtils;

public class ProductValidator {
    private ProductValidator(){

    }

    public static void execute(Product product){
        if(StringUtils.isEmpty(product.getName())){
            throw new ProductNotValidException("Name is required");
        }

        if(product.getDescription().length() > 20){
            throw new ProductNotValidException("Description must be under 20 characters");
        }

        if(product.getPrice() == null || product.getPrice() < 0){
            throw new ProductNotValidException("Price cannot be less that 0");
        }
    }
}
