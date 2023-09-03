package vendingmachine;

public class NotEnoughMoneyException extends Throwable {

    private final Product product;
    private final int price;

    public NotEnoughMoneyException(Product product, int price) {
        super(String.format("This %s is %d cents", product, price));
        this.product = product;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public int getPrice() {
        return price;
    }
}
