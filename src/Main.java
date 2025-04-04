import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Assortment assortment = new Assortment();

    public static void main(String[] args) {
        // Инициализация начального каталога
        assortment.addProduct(new FoodProduct("Яблоки", 1.99, 0.5));
        assortment.addProduct(new ElectronicsProduct("Наушники", 49.99, 0.2));

        while(true) {
            System.out.println("\nМеню:");
            System.out.println("1. Просмотреть каталог");
            System.out.println("2. Добавить товар в каталог");
            System.out.println("3. Сформировать заказ");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");

            int choice = getIntInput(1, 4);

            if (choice == 1) {
                assortment.displayCatalog();
            } else if (choice == 2) {
                assortment.addProduct(ProductFactory.createProduct());
            } else if (choice == 3) {
                createOrder();
            } else if (choice == 4) {
                System.out.println("До свидания!");
                return;
            }
        }
    }

    private static void createOrder() {
        Cart cart = new Cart();

        while (true) {
            assortment.displayCatalog();
            System.out.print("\nВыберите товар (0 - завершить): ");
            int choice = getIntInput(0, assortment.size());

            if (choice == 0) break;

            Product product = assortment.getProduct(choice - 1);
            cart.addItem(product);
            System.out.println("Добавлен: " + product.getName());
        }

        cart.displayContents();
    }

    private static int getIntInput(int min, int max) {
        while (true) {
            String input = scanner.nextLine();
            try {
                int num = Integer.parseInt(input);
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.println("Число должно быть от " + min + " до " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число");
            }
        }
    }
}