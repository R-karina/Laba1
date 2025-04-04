import java.util.ArrayList;

class Cart {
    private final ArrayList<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public double getTotalWeight() {
        double total = 0;
        for (Product item : items) {
            total += item.getWeight();
        }
        return total;
    }

    public void displayContents() {
        System.out.println("\nТовары в корзине:");
        for (Product item : items) {
            System.out.println(item);
        }
        System.out.printf("Итого: $%.2f, %.2f кг\n", getTotalPrice(), getTotalWeight());
    }
}