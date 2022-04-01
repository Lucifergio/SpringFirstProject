package HomeworkLesson3.service;

import HomeworkLesson3.model.Product;
import HomeworkLesson3.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product edit(Product product) {
        return productRepository.edit(product);
    }

    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(new Product());
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}