package rca.restapi.year2B;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProduct(int id) {
        return repository.findById(id);
    }

    public List<Product> getProductsByPrice(int price) {
        return repository.findByPrice(price);
    }

    public void createProduct(Product product) {
        repository.save(product);
    }
}