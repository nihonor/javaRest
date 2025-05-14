    package rca.restapi.year2B;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.web.PageableDefault;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @CrossOrigin(origins = "*")
    @RequestMapping("/api/products")
    public class ProductController {
        @Autowired
        private ProductService productService;

        @GetMapping("/paged")
        public Page<Product> getPagedProducts(
                @PageableDefault(size = 5, sort = "id") Pageable pageable) {
            return productService.getAllProducts(pageable);
        }

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
        // Update existing product
        @PutMapping("/{id}")
        public void updateProduct(@PathVariable int id, @RequestBody Product product) {
            productService.updateProduct(id, product);
        }

        // Delete product
        @DeleteMapping("/{id}")
        public void deleteProduct(@PathVariable int id) {
            productService.deleteProduct(id);
        }

    }