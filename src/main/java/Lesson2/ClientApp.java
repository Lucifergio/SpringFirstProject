package Lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductProjectConfig.class);
        MessageRender messageRender = context.getBean(MessageRender.class);
        messageRender.renderProdAllData();
        messageRender.renderProdDataById(4);
        messageRender.addProductInCart(1);
        messageRender.addProductInCart(2);
        messageRender.addProductInCart(5);
        messageRender.renderCart();

    }
}
