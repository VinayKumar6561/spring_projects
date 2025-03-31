// ProductService.java
package com.example.second.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.second.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private JdbcTemplate jdbcTemplate; // For Basic JDBC Template

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate; // For Named JDBC Template

    // Simple message to check service layer is working
    public String getProductDetails() {
        return "Product Service is Running!";
    }

    // Add Product using JdbcTemplate
    public String addProduct(Product product) {
        String sql = "INSERT INTO product (id, name, price) VALUES (?, ?, ?)";
        int result = jdbcTemplate.update(sql, product.getId(), product.getName(), product.getPrice());
        return result > 0 ? "Product Added Successfully!" : "Failed to Add Product";
    }

    // Add Product using NamedJdbcTemplate
    public int addProductWithNamedTemplate(Product product) {
        String sql = "INSERT INTO product (id, name, price) VALUES (:id, :name, :price)";
        
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", product.getId());
        paramMap.put("name", product.getName());
        paramMap.put("price", product.getPrice());

        return namedJdbcTemplate.update(sql, paramMap);
    }

    // Fetch Product by ID (Using queryForList and manual List<Map>)
    public List<Map<String, Object>> getProductById(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id);

        List<Map<String, Object>> productList = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Map<String, Object> productMap = new HashMap<>();
            productMap.put("id", row.get("id"));
            productMap.put("name", row.get("name"));
            productMap.put("price", row.get("price"));
            productList.add(productMap);
        }
        return productList;
    }

    // Fetch Product by Name
    public List<Map<String, Object>> getProductByName(String name) {
        String sql = "SELECT * FROM product WHERE name = ?";
        return jdbcTemplate.queryForList(sql, name);
    }

    // Update Product
    public String updateProduct(Product product) {
        String sql = "UPDATE product SET name = ?, price = ? WHERE id = ?";
        int result = jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getId());
        return result > 0 ? "Product Updated Successfully!" : "Failed to Update Product";
    }

    // Delete Product by ID
    public String deleteProductById(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        int result = jdbcTemplate.update(sql, id);
        return result > 0 ? "Product Deleted Successfully!" : "Failed to Delete Product";
    }
} 
