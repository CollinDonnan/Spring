package com.example.Spring.product.Services;

import com.example.Spring.Command;
import com.example.Spring.product.Exceptions.ProductNotValidException;
import com.example.Spring.product.Model.Product;
import com.example.Spring.product.Model.ProductDTO;
import com.example.Spring.product.ProductRepository;
import com.example.Spring.product.Validators.ProductValidator;
import io.micrometer.common.util.StringUtils;
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

        ProductValidator.execute(product);


        Product save = productRepository.save(product);

       return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(save));
    }

}
