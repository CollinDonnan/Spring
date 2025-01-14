package com.example.Spring.product.Services;

import com.example.Spring.Command;
import com.example.Spring.product.Exceptions.ProductNotFoundExecption;
import com.example.Spring.product.Model.Product;
import com.example.Spring.product.Model.ProductDTO;
import com.example.Spring.product.Model.UpdateProductCommand;
import com.example.Spring.product.ProductRepository;
import com.example.Spring.product.Validators.ProductValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {

    private ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.getId());

        if(productOptional.isPresent()){
            Product product = command.getProduct();
            product.setId(command.getId());
            ProductValidator.execute(product);
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }

        throw new ProductNotFoundExecption();
    }
}
