package Lesson2;

public interface ProductRepository {
    String getProductData();
    String getProductDataById(int id);
    Product getProductById(int id);
}
