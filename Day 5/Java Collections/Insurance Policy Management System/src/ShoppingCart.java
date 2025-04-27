import java.util.*;

public class ShoppingCart {
    private HashMap<String, Double> priceMap = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    // Add or update product price
    public void setProductPrice(String product, double price) {
        priceMap.put(product, price);
    }

    // Add product to cart
    public void addToCart(String product, int quantity) {
        if (!priceMap.containsKey(product)) {
            System.out.println("Product not found in price list: " + product);
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    // Display cart in insertion order
    public void displayCartInOrder() {
        System.out.println("Cart (in order added):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = priceMap.get(product);
            System.out.println(product + " × " + quantity + " = $" + (price * quantity));
        }
    }

    // Display cart sorted by price
    public void displayCartSortedByPrice() {
        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

        for (String product : cart.keySet()) {
            double price = priceMap.get(product);
            sortedByPrice.putIfAbsent(price, new ArrayList<>());
            sortedByPrice.get(price).add(product);
        }

        System.out.println("\nCart (sorted by price):");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            double price = entry.getKey();
            for (String product : entry.getValue()) {
                int quantity = cart.get(product);
                System.out.println(product + " × " + quantity + " = $" + (price * quantity));
            }
        }
    }

    // Calculate total
    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += priceMap.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }
}


class ShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Set product prices
        cart.setProductPrice("Apple", 1.50);
        cart.setProductPrice("Banana", 0.75);
        cart.setProductPrice("Orange", 1.20);
        cart.setProductPrice("Milk", 2.00);

        // Add products to cart
        cart.addToCart("Apple", 3);
        cart.addToCart("Milk", 1);
        cart.addToCart("Orange", 2);
        cart.addToCart("Banana", 4);

        // Display cart
        cart.displayCartInOrder();
        cart.displayCartSortedByPrice();

        // Total
        System.out.println("\nTotal: $" + cart.calculateTotal());
    }
}
