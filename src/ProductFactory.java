// Определяет фабричный метод для создания продуктов.

interface ProductFactory {
    Product createProduct(String name, double price, double weight);
}