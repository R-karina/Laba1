//  Реализует паттерн Singleton и управляет каталогом продуктв.

import java.util.*;

class Catalog {
    private static Catalog instance;  //Единственный экземпляр класса
    private Map<String, Product> products;

    private Catalog() {
        products = new HashMap<>();
        initializeCatalog(); // Инициализация каталога с товарами
    }

    public static Catalog getInstance() {
        if (instance == null) {
            instance = new Catalog();
        }
        return instance;
    }

    private void initializeCatalog() {
        addProduct(new Food("Яблоко", 1.0, 0.2));
        addProduct(new Food("Банан", 1.5, 0.15));
        addProduct(new Electronics("Ноутбук", 50000.0, 2.0));
        addProduct(new Electronics("Телефон", 30000.0, 0.5));
    }

    public void addProduct(Product product) {
        products.put(product.getName(), product);
        System.out.println("Продукт '" + product.getName() + "' добавлен в каталог.");
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public Iterator<Product> getIterator() {
        return products.values().iterator();
    }
}