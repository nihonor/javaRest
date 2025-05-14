package rca.restapi.year2B;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Product> getAllProducts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void updateProduct(int id, Product updatedProduct) {
        if (repository.existsById(id)) {
            updatedProduct.setId(id); // Ensure the ID stays consistent
            repository.save(updatedProduct);
        }
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }


}