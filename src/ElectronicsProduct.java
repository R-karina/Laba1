
class ElectronicsProduct extends Product {
    public ElectronicsProduct(String name, double price, double weight) {
        super(name, price, weight);
    }

    @Override
    public String getType() {
        return "Электроника";
    }
}

