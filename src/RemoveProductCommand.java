class RemoveProductCommand implements Command {
    private ShoppingCart cart;
    private String productName;

    public RemoveProductCommand(ShoppingCart cart, String productName) {
        this.cart = cart;
        this.productName = productName;
    }

    @Override
    public void execute() {
        cart.removeProduct(productName);
    }
}