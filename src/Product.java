//Определяет общие свойства для всех продуктов, которые могут быть добавлены в каталог.
interface Product {
    String getName();
    double getPrice();
    double getWeight();
    void displayInfo();
}
