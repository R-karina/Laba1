import java.util.ArrayList;


class Assortment {
    private final ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayCatalog() {
        System.out.println("\nДоступные товары:");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, products.get(i));
        }
    }

    public Product getProduct(int index) {
        return products.get(index);
    }

    public int size() {
        return products.size();
    }
}