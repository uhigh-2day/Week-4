public class Main {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Apple"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Displaying Electronics:");
        WarehouseUtils.displayAllItems(electronicsStorage.getAllItems());

        System.out.println("\nDisplaying Groceries:");
        WarehouseUtils.displayAllItems(groceriesStorage.getAllItems());

        System.out.println("\nDisplaying Furniture:");
        WarehouseUtils.displayAllItems(furnitureStorage.getAllItems());
    }
}
