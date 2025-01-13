package com.example.Spring.product;



import com.example.Spring.product.Model.Product;
import com.example.Spring.product.Model.ProductDTO;
import com.example.Spring.product.Services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    private final CreateProductService createProductService;


    private final UpdateProductService updateProductService;


    private final GetProductService getProductService;

    private final GetProductsService getProductsService;

    private final DeleteProductService deleteProductService;

    public ProductController(GetProductsService getProductsService,
                             CreateProductService createProductService,
                             UpdateProductService updateProductService,
                             DeleteProductService deleteProductService,
                             GetProductService getProductService) {
        this.getProductService = getProductService;
        this.createProductService = createProductService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
        this.getProductsService = getProductsService;
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> createController(@RequestBody Product product){
        return createProductService.execute(product);
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getProducts(){
        return getProductsService.execute(null);
    }

    @GetMapping()
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        return getProductService.execute(id);
    }

    @PutMapping()
    public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody Product product){
        return updateProductService.execute(null);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(){
        return deleteProductService.execute(null);
    }
}
