package com.example.Spring.product.Services;

import com.example.Spring.Query;
import com.example.Spring.product.Exceptions.ProductNotFoundExecption;
import com.example.Spring.product.Model.Product;
import com.example.Spring.product.Model.ProductDTO;
import com.example.Spring.product.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {

    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ResponseEntity<ProductDTO> execute(Integer input){
        Optional<Product> productOptional= productRepository.findById(input);

        if(productOptional.isPresent()){
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }
        throw new ProductNotFoundExecption();
    }
}
