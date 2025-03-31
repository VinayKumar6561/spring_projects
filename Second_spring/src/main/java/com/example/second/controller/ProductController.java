
// ProductController.java
package com.example.second.controller;

import org.springframework.web.bind.annotation.*;
import com.example.second.model.Product;
import com.example.second.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService; // Inject Service Layer

    // Get Product Details (Just for testing)
    @GetMapping("/product")
    public String getProduct() {
        return productService.getProductDetails();
    }

    // Fetch Product by ID
    @GetMapping("/product/{id}")
    public List<Map<String, Object>> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    // Fetch Product by Name
    @GetMapping("/product/by-name")
    public List<Map<String, Object>> getProductByName(@RequestParam String name) {
        return productService.getProductByName(name);
    }

    // Add Product using JdbcTemplate
    @PostMapping("/product")
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Add Product using NamedJdbcTemplate
    @PostMapping("/product/named")
    public String addProductWithNamed(@RequestBody Product product) {
        return productService.addProductWithNamedTemplate(product) > 0 
                ? "Product Added Successfully!" 
                : "Failed to Add Product";
    }

    // Update Product
    @PutMapping("/product/update")
    public String updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    // Delete Product by ID
    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProductById(id);
    }
}
