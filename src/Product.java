abstract class Product {
    protected String name;
    protected double weight;
    protected double price;

    public Product(String name, double price, double weight){
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public abstract String getType();

    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getWeight() { return weight; }


    @Override
    public String toString() {
        return String.format("%s [%s] - $%.2f, %.2f кг", name, getType(), price, weight);    }
}