package Lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleProductRender implements MessageRender {

    private ProductRepository productRepository;
    private Cart cartProduct;

    @Autowired
    public ConsoleProductRender(ProductRepository productRepository, Cart cart) {

        this.productRepository = productRepository;
        this.cartProduct = cart;
    }

    @Override
    public void renderProdAllData() {

        System.out.println(productRepository.getProductData());
    }

    @Override
    public void renderProdDataById(int id) {
        System.out.println(productRepository.getProductDataById(id));
    }

    public void addProductInCart (int id) {
            getCart().addProductInCart(productRepository.getProductById(id));
    }
    @Override
    public void setProdRep(ProductRepository prodRep) {
        this.productRepository = prodRep;
    }

    @Override
    public ProductRepository getProdRep() {
        return this.productRepository;
    }

    @Override
    public void renderCart() {
        System.out.println(cartProduct.printCart());
    }

    @Override
    public void setCart(Cart cart) {
        this.cartProduct = cart;
    }

    @Override
    public Cart getCart() {
        return this.cartProduct;
    }
}
