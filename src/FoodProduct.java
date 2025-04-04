
class FoodProduct extends Product {
    public FoodProduct(String name, double price, double weight) {
        super(name, price, weight);
    }

    @Override
    public String getType() {
        return "Еда";
    }
}
