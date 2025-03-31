//package com.example.second.dao;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Repository;
//import com.example.second.model.Product;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//@Repository
//public class ProductDAO {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate; // JDBC Template to interact with DB
//    
//    @Autowired
//    private NamedParameterJdbcTemplate namedJdbcTemplate; // Named JDBC Template
//    
//    // Add Product (Using NamedJdbcTemplate)
//    public int addProductWithNamedTemplate(Product product) {
//        String sql = "INSERT INTO product (id, name, price) VALUES (:id, :name, :price)";
//        
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", product.getId());
//        paramMap.put("name", product.getName());
//        paramMap.put("price", product.getPrice());
//        
//        return namedJdbcTemplate.update(sql, paramMap);
//    }
//    // Add Product
//    public int addProduct(Product product) {
//        String sql = "INSERT INTO product (id, name, price) VALUES (?, ?, ?)";
//        return jdbcTemplate.update(sql, product.getId(), product.getName(), product.getPrice());
//    }
//
//    // Get Product By ID
//    public Product getProductById(int id) {
//        String sql = "SELECT * FROM product WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Product(
//            rs.getInt("id"),
//            rs.getString("name"),
//            rs.getDouble("price")
//        ), id);
//    }
//    // Fetch Product By Name ✅
//    public Product getProductByName(String name) {
//        String sql = "SELECT * FROM product WHERE name = ?";
//        return jdbcTemplate.query(sql, rs -> {
//            if (rs.next()) {
//                Product product = new Product();
//                product.setId(rs.getInt("id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getDouble("price"));
//                return product;
//            } else {
//                return null; // Return null if no product found
//            }
//        }, name);
//    }
//
//
//    
//
//    // Update Product
//    public int updateProduct(Product product) {
//        String sql = "UPDATE product SET name = ?, price = ? WHERE id = ?";
//        return jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getId());
//    }
//
//    // Delete Product
//    public int deleteProductById(int id) {
//        String sql = "DELETE FROM product WHERE id = ?";
//        return jdbcTemplate.update(sql, id);
//    }
//}