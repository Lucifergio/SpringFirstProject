package Lesson2;

public class Product {
    private int id;
    private String title;
    private int cost;

    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product() {
        this.id = 1;
        this.title = "ddd";
        this.cost = 100;
    }

    public String getData() {
        return ("Id: " + id + " Title: " + title + " Cost: " + cost);
    }

    public boolean checkId(int id) {
        if (this.id == id) {
            return true;
        } else {
            return false;
        }
    }
}
