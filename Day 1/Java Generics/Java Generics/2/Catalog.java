import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Product<?>> products = new ArrayList<>();

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    public void displayCatalog() {
        for (Product<?> product : products) {
            product.displayInfo();
        }
    }
}
