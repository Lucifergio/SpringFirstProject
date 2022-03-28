package Lesson2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class ProductRepositoryImpl implements ProductRepository {

    @InjectProduct
    List<Product> products = new ArrayList<>();

    @Override
    public String getProductData() {

        String data = "All product in the ProductRepository: \n";
        for (Product prod : products) {
            data += prod.getData() + "\n";

        }
        return data;
    }

    @Override
    public String getProductDataById(int id) {
        System.out.println("Search result by Id - " + id);
        for (Product prod : products) {
            if (prod.checkId(id)) {
                return prod.getData();
            }
        }
        return "No product found with this id.";
    }

    @Override
    public Product getProductById(int id) {
        for (Product prod : products) {
            if (prod.checkId(id)) {
                return prod;
            }
        }
        return null;
    }

}
