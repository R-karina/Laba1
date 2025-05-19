class ElectronicsFactory implements ProductFactory {
    @Override
    public Product createProduct(String name, double price, double weight) {
        return new Electronics(name, price, weight);
    }
}