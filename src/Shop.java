import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Customer> customers;
    private List<Product> products;
    private List<Order> orders;

    public Shop() {
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    // Добавление покупателя в магазин
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Добавление товара в магазин
    public void addProduct(Product product) {
        products.add(product);
    }

    // Создание заказа и добавление его в магазин
    public void makePurchase(Customer customer, Product product, int amount) throws CustomerException, ProductException, AmountException {
        if (!customers.contains(customer)) {
            throw new CustomerException("Invalid customer: " + customer.getFirstName());
        }

        if (!products.contains(product)) {
            throw new ProductException("Invalid product: " + product.getTitle());
        }

        if (amount <= 0 || amount > 100) {
            throw new AmountException("Invalid amount: " + amount);
        }
        Order order = new Order(customer, product, amount);
        orders.add(order);
    }

    // Вывод информации о каждом заказе
    public void printOrders() {
        for (Order order : orders) {
            Customer customer = order.getCustomer();
            Product product = order.getProduct();
            int quantity = order.getAmount();
            double totalPrice = order.getTotalPrice();
            Discount discount = product.getDiscount();

            System.out.println("Order Information:");
            System.out.println("Customer: " + customer.getFirstName());
            System.out.println("Product: " + product.getTitle());
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price: $" + totalPrice);
            System.out.println("Discount: " + discount.getPercentage() * 100 + "%");
            System.out.println("--------------------");
        }
    }
    public static void main(String[] args) {
        Shop shop = new Shop();

        // Добавление покупателей
        Customer customer1 = new Customer("Anna", "Ivanova", 25, "+79536875468", Gender.FEMALE);
        Customer customer2 = new Customer("Oleg", "Petrov", 42, "+79565121787", Gender.MALE);
        shop.addCustomer(customer1);
        shop.addCustomer(customer2);

        // Добавление товаров
        Product product1 = new Product("Coffee", 299.99f);
        Product product2 = new Product("Bread", 38.5f);
        Product product3 = new Product("Cheese", 600);
        Product product4 = new Product("Butter", 115);
        Product product5 = new Product("Eggs", 54.60f);
        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);
        shop.addProduct(product4);
        shop.addProduct(product5);

        try {
            // Совершение покупок
            shop.makePurchase(customer1, product1, 2);
            shop.makePurchase(customer2, product2, 1);
            shop.makePurchase(customer1, product3, 3);
            shop.makePurchase(customer1, product4, 2);
            shop.makePurchase(customer2, product5, 1);
        } catch (CustomerException | ProductException | AmountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Вывод информации о заказах
        shop.printOrders();
    }
}
