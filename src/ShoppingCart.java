// Корзина для управления продуктами
import java.util.*;

class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Продукт '" + product.getName() + "' добавлен в корзину.");
    }

    public void displayCartContents() {
        System.out.println("Товары в корзине:");
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            for (Product product : products) {
                product.displayInfo();
            }
        }
    }

    public void removeProduct(String productName) {
        Product product = products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);

        if (product != null) {
            products.remove(product);
            System.out.println("Продукт '" + productName + "' удален из корзины.");
        } else {
            System.out.println("Продукт '" + productName + "' не найден в корзине.");
        }
    }

    public double calculateTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public double calculateTotalWeight() {
        return products.stream().mapToDouble(Product::getWeight).sum();
    }

    public Iterator<Product> getIterator() {
        return products.iterator();
    }
}