package limitorderbook;

public class Order implements Comparable<Order> {

    public enum OrderType { BUY, SELL }
    public enum PriceType { MARKET, LIMIT }

    private int time;
    private OrderType orderType;
    private int size;
    private PriceType priceType;
    private double price;

    public Order(OrderType orderType, int size) {
        this.orderType = orderType;
        this.size = size;
        this.priceType = PriceType.MARKET;
    }

    public Order(OrderType orderType, int size, double price) {
        this.orderType = orderType;
        this.size = size;
        this.priceType = PriceType.LIMIT;
        this.price = price;
    }

    public Order(int time, OrderType orderType, int size) {
        this.time = time;
        this.orderType = orderType;
        this.size = size;
        this.priceType = PriceType.MARKET;
    }

    public Order(int time, OrderType orderType, int size, double price) {
        this.time = time;
        this.orderType = orderType;
        this.size = size;
        this.priceType = PriceType.LIMIT;
        this.price = price;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int compareTo(Order order) {
        return time - order.time;
    }
}
