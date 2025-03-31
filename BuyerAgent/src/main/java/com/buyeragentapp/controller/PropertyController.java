package com.buyeragentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.buyeragentapp.model.Property;
import com.buyeragentapp.service.PropertyService;
import java.util.List;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend requests
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    // Add a property
    @PostMapping("/add")
    public String addProperty(@RequestBody Property property) {
        int result = propertyService.addProperty(property);
        return result > 0 ? "Property added successfully!" : "Failed to add property.";
    }

    // Get all properties
    @GetMapping("/all")
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }
}
