package test.design;

import limitorderbook.Order;
import limitorderbook.Order.*;
import limitorderbook.OrderBook;
import org.junit.Test;

import java.util.List;

public class TestDesignProb4 {

    @Test
    public void testMatching() {
        List<Order> sellOrders = List.of(
                new Order(OrderType.SELL, 1, 1.03),
                new Order(OrderType.SELL, 1, 1.01),
                new Order(OrderType.SELL, 1, 1.02)
        );
        List<Order> buyOrders = List.of(
                new Order(OrderType.BUY, 1, 0.99),
                new Order(OrderType.BUY, 1, 0.97),
                new Order(OrderType.BUY, 1, 0.98)
        );
        OrderBook orderBook = new OrderBook(sellOrders, buyOrders);
        Order marketOrder1 = new Order(OrderType.BUY, 1);
        Order limitOrder1 = new Order(OrderType.BUY, 1, 1.02);
        Order marketOrder2 = new Order(OrderType.SELL, 1);
        Order limitOrder2 = new Order(OrderType.SELL, 1, 0.98);
        orderBook.match(marketOrder1, limitOrder1, marketOrder2, limitOrder2);

    }
}
