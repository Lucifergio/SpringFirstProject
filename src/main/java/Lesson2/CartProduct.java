package Lesson2;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CartProduct implements Cart {

    List<Product> productCart;

    public CartProduct() {
        this.productCart = new LinkedList<>();
    }

    @Override
    public void addProductInCart(Product product) {
        productCart.add(product);
    }

    @Override
    public String printCart() {
        String data = "Products in the cart : \n";
        if (!productCart.isEmpty()) {
            for (Product prod : productCart) {
                data += prod.getData() + "\n";
            }
            return data;
        }
        return "There are no products in the cart.";
    }
}
