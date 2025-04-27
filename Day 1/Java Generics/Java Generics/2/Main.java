public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        Book book = new Book("Java Programming", 39.99, BookCategory.EDUCATIONAL);
        Clothing tshirt = new Clothing("Cool T-Shirt", 19.99, ClothingCategory.MENS);
        Gadget phone = new Gadget("Smartphone X", 699.99, GadgetCategory.SMARTPHONE);

        catalog.addProduct(book);
        catalog.addProduct(tshirt);
        catalog.addProduct(phone);

        System.out.println("Before Discount:");
        catalog.displayCatalog();

        // Apply discounts
        MarketplaceUtils.applyDiscount(book, 10);     // 10% off
        MarketplaceUtils.applyDiscount(tshirt, 20);   // 20% off
        MarketplaceUtils.applyDiscount(phone, 5);     // 5% off

        System.out.println("\nAfter Discount:");
        catalog.displayCatalog();
    }
}
