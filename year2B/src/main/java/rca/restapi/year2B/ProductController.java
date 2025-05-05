package rca.restapi.year2B;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productService.getProduct(id);
    }

    // Get products by price
    @GetMapping("/price/{price}")
    public List<Product> getProductsByPrice(@PathVariable int price) {
        return productService.getProductsByPrice(price);
    }

    // Create new product
    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }
}