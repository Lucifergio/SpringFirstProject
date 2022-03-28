package Lesson2;

public interface MessageRender {

    void renderProdAllData();
    void renderProdDataById(int id);
    void setProdRep(ProductRepository prodRep);
    ProductRepository getProdRep();
    void renderCart();
    void setCart(Cart cart);
    Cart getCart();
    void addProductInCart (int id);

}
