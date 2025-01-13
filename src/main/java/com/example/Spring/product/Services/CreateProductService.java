package com.example.Spring.product.Services;

import com.example.Spring.Command;
import com.example.Spring.product.Model.Product;
import com.example.Spring.product.Model.ProductDTO;
import com.example.Spring.product.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {


    private  final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {
        Product save = productRepository.save(product);

       return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(save));
    }
}
