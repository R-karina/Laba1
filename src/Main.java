// Основной класс для взаимодействия с пользователем
import java.util.*;

public class Main {
    private static ShoppingFacade facade = new ShoppingFacade(); //для оаботы  с каталогом и корзиной.
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Выберите режим: 1 - Администратор, 2 - Покупатель, 0 - Выход");
            int mode = scanner.nextInt();
            scanner.nextLine(); // Потребление новой строки

            if (mode == 0) {
                break;
            } else if (mode == 1) {
                adminMode();
            } else if (mode == 2) {
                customerMode();
            } else {
                System.out.println("Неверный режим. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static void adminMode() {
        while (true) {
            System.out.println("Режим администратора: 1 - Добавить продукт, 2 - Добавить гарантию, 3 - Показать каталог, 0 - Назад");
            int option = scanner.nextInt();
            scanner.nextLine(); // Потребление новой строки

            if (option == 0) {
                break;
            } else if (option == 1) {
                System.out.println("Введите тип продукта (1 для еды, 2 для электроники):");
                int type = scanner.nextInt();
                scanner.nextLine(); // Потребление новой строки
                System.out.println("Введите название продукта:");
                String name = scanner.nextLine();
                System.out.println("Введите цену продукта:");
                double price = scanner.nextDouble();
                System.out.println("Введите вес продукта:");
                double weight = scanner.nextDouble();

                Product product;
                if (type == 1) {
                    product = new Food(name, price, weight);
                } else {
                    product = new Electronics(name, price, weight);
                }
                facade.addProductToCatalog(product);
            } else if (option == 2) {
                System.out.println("Введите название продукта, чтобы добавить гарантию:");
                String productName = scanner.nextLine();
                System.out.println("Введите детали гарантии:");
                String warranty = scanner.nextLine();
                facade.addWarrantyToProduct(productName, warranty);
            } else if (option == 3) {
                facade.displayCatalog();
            } else {
                System.out.println("Неверный вариант. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static void customerMode() {
        while (true) {
            System.out.println("Режим покупателя: 1 - Добавить продукт в корзину, 2 - Удалить продукт из корзины, 3 - Показать каталог, 4 - Просмотреть корзину, 0 - Назад");
            int option = scanner.nextInt();
            scanner.nextLine(); // Потребление новой строки

            if (option == 0) {
                break;
            } else if (option == 1) {
                while (true) {
                    System.out.println("Введите название продукта, чтобы добавить в корзину (или введите 0 для выхода):");
                    String productName = scanner.nextLine();
                    if (productName.equals("0")) {
                        break; // Выход из внутреннего цикла
                    }
                    facade.addProductToCart(productName);
                }
                // Вывод итоговой суммы и веса после добавления товаров
                facade.calculateCartTotal();
            } else if (option == 2) {
                System.out.println("Введите название продукта, чтобы удалить из корзины:");
                String productName = scanner.nextLine();
                facade.removeProductFromCart(productName);
            } else if (option == 3) {
                facade.displayCatalog();
            } else if (option == 4) {
                // Просмотр содержимого корзины
                System.out.println("Содержимое корзины:");
                facade.getCart().displayCartContents(); // Добавляем вывод содержимого корзины
            } else {
                System.out.println("Неверный вариант. Пожалуйста, попробуйте снова.");
            }
        }
    }

}