package com.ecom.productcatolog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecom.productcatolog.model.Product;
import com.ecom.productcatolog.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Fetch all products
     * @return List of products
     */
    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            System.out.println("✅ Fetched Products: " + products.size());
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            System.err.println("❌ Error fetching products: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error fetching products: " + e.getMessage());
        }
    }

    /**
     * Fetch products by category
     * @param categoryId ID of category
     * @return List of products belonging to category
     */
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getAllProductsByCategory(@PathVariable Long categoryId) {
        try {
            List<Product> products = productService.getProductByCategory(categoryId);
            System.out.println("✅ Fetched Products for Category ID " + categoryId + ": " + products.size());
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            System.err.println("❌ Error fetching category products: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error fetching category products: " + e.getMessage());
        }
    }
}
