// Декоратор для добавления гарантии к электронике.

class WarrantyDecorator extends Electronics {
    private Electronics electronics;
    private String extendedWarranty;

    public WarrantyDecorator(Electronics electronics, String extendedWarranty) {
        super(electronics.getName(), electronics.getPrice(), electronics.getWeight());
        this.electronics = electronics;
        this.extendedWarranty = extendedWarranty;
    }

    @Override
    public void displayInfo() {
        electronics.displayInfo();
        System.out.println(" + Расширенная гарантия: " + extendedWarranty);
    }

    @Override
    public String getWarranty() {
        return extendedWarranty;
    }

    @Override
    public void setWarranty(String warranty) {
        this.extendedWarranty = warranty;
    }
}