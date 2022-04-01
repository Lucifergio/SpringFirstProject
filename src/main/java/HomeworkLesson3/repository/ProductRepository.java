package HomeworkLesson3.repository;

import HomeworkLesson3.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
@Primary
public class ProductRepository {

    List<Product> products = new LinkedList<>();
    private int count;

    public Product save(Product product) {

        product.setId(count++);
        products.add(product);

        return Product.builder()
                .id(product.getId())
                .title(product.getTitle())
                .cost(product.getCost())
                .build();
    }

    public Product edit(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                return products.set(i, product);
            }
        }
        return null;
    }

    public Optional<Product> findById(Integer id) {

        for (Product prod : products) {
            if (prod.getId() == id) {
                return Optional.of(prod);
            }
        }
        return Optional.empty();
    }


    public List<Product> findAll() {
        return new LinkedList<>(products);
    }

    public void deleteById(Integer id) {

        if (id < products.size()) {
            for (Product prod : products) {
                if (prod.getId() == id) {
                    products.remove(prod);
                    return;
                }
            }
        }
    }
}