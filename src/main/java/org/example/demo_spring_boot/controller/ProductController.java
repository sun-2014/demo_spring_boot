package org.example.demo_spring_boot.controller;

import jakarta.validation.Valid;
import org.example.demo_spring_boot.model.Product;
import org.example.demo_spring_boot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products") //name of endpoint
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
//new comment
    @Autowired
    private ProductRepository productRepository;

    // ---------------- CREATE (POST) ----------------
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    // ---------------- READ (GET ALL) ----------------
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ---------------- READ (GET BY ID) ----------------
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    // ---------------- UPDATE (PUT) ----------------
    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody Product updatedProduct) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());

        return productRepository.save(existingProduct);
    }

    // ---------------- DELETE ----------------
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));

        productRepository.delete(product);
        return "Product deleted successfully with id " + id;
    }
}
