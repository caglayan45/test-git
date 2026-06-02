import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(String name, double price, int quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Product price must be greater than zero.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Product quantity must be greater than zero.");
        }

        Product product = new Product(name, price, quantity);
        products.add(product);
    }

    public void removeProduct(String name) {
        Product productToRemove = null;

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove == null) {
            System.out.println(name + " not found in cart.");
            return;
        }

        products.remove(productToRemove);
        System.out.println(name + " removed from cart.");
    }

    public double calculateTotalPrice() {
        double total = 0;

        for (Product product : products) {
            total += product.getTotalPrice();
        }

        return total;
    }

    public void printCart() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("Shopping Cart:");
        System.out.println("-------------------------");

        for (Product product : products) {
            System.out.println("Product: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Total: " + product.getTotalPrice());
            System.out.println("-------------------------");
        }

        System.out.println("Cart Total: " + calculateTotalPrice());
    }

    public int getProductCount() {
        return products.size();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 35000, 1);
        cart.addProduct("Mouse", 750, 2);
        cart.addProduct("Keyboard", 1500, 1);

        cart.printCart();

        cart.removeProduct("Mouse");

        cart.printCart();
    }

    private static class Product {

        private final String name;
        private final double price;
        private final int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getTotalPrice() {
            return price * quantity;
        }
    }
}