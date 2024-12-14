package Lab7;
import java.util.*;

// Customer Class
class Customer {
    private String customerId;
    private String name;
    private int loyaltyPoints;

    public Customer(String customerId, String name, int loyaltyPoints) {
        this.customerId = customerId;
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Loyalty Points: " + loyaltyPoints;
    }
}

// Product Class
class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + name + ", Price: " + price;
    }
}

// Order Class
class Order {
    private String orderId;
    private String customerId;
    private Date deliveryDate;

    public Order(String orderId, String customerId, Date deliveryDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.deliveryDate = deliveryDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer ID: " + customerId + ", Delivery Date: " + deliveryDate;
    }
}

// Comparator for Products by Price
class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}

// Comparator for Orders by Delivery Date
class OrderDeliveryDateComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getDeliveryDate().compareTo(o2.getDeliveryDate());
    }
}

public class AmazonApplication {

    public static void main(String[] args) {
        // Using ArrayList for customers, products, and orders
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        // Using HashMap for fast retrieval
        HashMap<String, Customer> customerMap = new HashMap<>();
        HashMap<String, Product> productMap = new HashMap<>();

        // Using HashSet to avoid duplicate products for customers
        HashSet<Product> uniqueProducts = new HashSet<>();

        // Using TreeSet with custom sorting
        TreeSet<Product> sortedProducts = new TreeSet<>(new ProductPriceComparator());
        TreeSet<Order> sortedOrders = new TreeSet<>(new OrderDeliveryDateComparator());

        // Adding Customers
        Customer c1 = new Customer("C001", "Alice", 120);
        Customer c2 = new Customer("C002", "Bob", 80);
        customers.add(c1);
        customers.add(c2);
        customerMap.put(c1.getCustomerId(), c1);
        customerMap.put(c2.getCustomerId(), c2);

        // Adding Products
        Product p1 = new Product("P001", "Laptop", 1500.0);
        Product p2 = new Product("P002", "Phone", 800.0);
        products.add(p1);
        products.add(p2);
        productMap.put(p1.getProductId(), p1);
        productMap.put(p2.getProductId(), p2);
        uniqueProducts.add(p1);
        uniqueProducts.add(p2);
        sortedProducts.add(p1);
        sortedProducts.add(p2);

        // Adding Orders
        Order o1 = new Order("O001", "C001", new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime());
        Order o2 = new Order("O002", "C002", new GregorianCalendar(2024, Calendar.DECEMBER, 10).getTime());
        orders.add(o1);
        orders.add(o2);
        sortedOrders.add(o1);
        sortedOrders.add(o2);

        // Displaying Customers
        System.out.println("Customers:");
        for (Customer c : customers) {
            System.out.println(c);
        }

        // Displaying Products
        System.out.println("\nProducts:");
        for (Product p : sortedProducts) {
            System.out.println(p);
        }

        // Displaying Orders
        System.out.println("\nOrders:");
        for (Order o : sortedOrders) {
            System.out.println(o);
        }
    }
}
