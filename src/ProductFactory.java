import java.util.Scanner;

class ProductFactory {
    private static final Scanner scanner = new Scanner(System.in);

    public static Product createProduct() {
        System.out.println("\nДобавление нового товара:");

        System.out.print("Тип товара (1 - Еда, 2 - Электроника): ");
        int typeChoice = getIntInput(1, 2);

        System.out.print("Название: ");
        String name = scanner.nextLine();

        System.out.print("Цена: ");
        double price = getDoubleInput();

        System.out.print("Вес (кг): ");
        double weight = getDoubleInput();

        if (typeChoice == 1) {
            return new FoodProduct(name, price, weight);
        } else {
            return new ElectronicsProduct(name, price, weight);
        }
    }

    static int getIntInput(int min, int max) {
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

    private static double getDoubleInput() {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
            }
        }
    }
}