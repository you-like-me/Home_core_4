public class Order {
    private Customer customer;
    private Product product;
    private int amount;
    private double totalPrice;

    public Order(Customer customer, Product product, int amount) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.totalPrice = calculateTotalPrice();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    private double calculateTotalPrice(){
        double discountedPrice = product.getPrice() - (product.getPrice() * product.getDiscount().getPercentage());
        return discountedPrice * amount;
    }
}
