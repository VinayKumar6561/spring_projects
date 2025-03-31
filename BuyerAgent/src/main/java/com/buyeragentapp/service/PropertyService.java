package com.buyeragentapp.service;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.buyeragentapp.model.Property;

@Service
public class PropertyService {
    private final JdbcTemplate jdbcTemplate;

    public PropertyService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Add property
    public int addProperty(Property property) {
        String sql = "INSERT INTO properties (title, description, price, agent_id, owner_name, owner_contact) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
            property.getTitle(), 
            property.getDescription(), 
            property.getPrice(), 
            property.getAgentId(),
            property.getOwnerName(),
            property.getOwnerContact()
        );
    }

    // Retrieve all properties
    public List<Property> getAllProperties() {
        String sql = "SELECT * FROM properties";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Property(
            rs.getInt("id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getDouble("price"),
            rs.getInt("agent_id"),
            rs.getString("owner_name"),
            rs.getString("owner_contact")
        ));
    }
}
