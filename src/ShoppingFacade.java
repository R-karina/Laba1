//  Упрощает взаимодействие между пользователем, каталогом и корзиной.
import java.util.*;

class ShoppingFacade {
    private Catalog catalog;
    private ShoppingCart cart;

    public ShoppingFacade() {
        catalog = Catalog.getInstance();
        cart = new ShoppingCart();
    }

    public void addProductToCatalog(Product product) {
        catalog.addProduct(product);
    }

    public void addProductToCart(String productName) {
        Product product = catalog.getProduct(productName);
        if (product != null) {
            cart.addProduct(product);
        } else {
            System.out.println("Продукт '" + productName + "' не найден в каталоге.");
        }
    }

    public void removeProductFromCart(String productName) {
        Command command = new RemoveProductCommand(cart, productName);
        command.execute();
    }

    public void displayCatalog() {
        System.out.println("Продукты в каталоге:");
        Iterator<Product> iterator = catalog.getIterator();
        while (iterator.hasNext()) {
            iterator.next().displayInfo();
        }
    }

    public void calculateCartTotal() {
        System.out.println("Общая стоимость: " + cart.calculateTotalPrice());
        System.out.println("Общий вес: " + cart.calculateTotalWeight());
    }

    public void addWarrantyToProduct(String productName, String warranty) {
        Product product = catalog.getProduct(productName);
        if (product instanceof Electronics) {
            Electronics electronics = (Electronics) product;
            WarrantyDecorator decoratedProduct = new WarrantyDecorator(electronics, warranty);
            catalog.addProduct(decoratedProduct);
            System.out.println("Гарантия добавлена к продукту '" + productName + "'");
        } else {
            System.out.println("Гарантия может быть добавлена только к электронике.");
        }
    }
    public ShoppingCart getCart() {
        return cart;
    }
}