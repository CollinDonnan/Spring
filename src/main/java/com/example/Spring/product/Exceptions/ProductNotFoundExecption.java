package com.example.Spring.product.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundExecption extends RuntimeException{
    public ProductNotFoundExecption() {
        super("Product Not Found");
    }
}
