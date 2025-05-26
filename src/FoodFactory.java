//Реализует интерфейс `ProductFactory` для создания продуктов питания.

class FoodFactory {
    @Override
    public Product createProduct(String name, double price, double weight) {
        return new Food(name, price, weight);
    }
}
