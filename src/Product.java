public class Product {
    private String title;
    private float price;
    private Discount discount;

    public Product(String name, float price) {
        this.title = name;
        this.price = price;
        this.discount = Discount.randomDiscount();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
