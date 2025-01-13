package com.example.Spring.product.Services;

import com.example.Spring.Command;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService implements Command<Void, String> {

    @Override
    public ResponseEntity<String> execute(Void input) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product Deleted");
    }
}
