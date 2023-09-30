package test.design;

import java.util.List;
import limitorderbook.Order;
import limitorderbook.Order.*;
import limitorderbook.OrderBook;
import org.junit.Assert;
import org.junit.Test;

public class TestDesignProb4 {

    @Test
    public void testMatching() {
        List<Order> buyOrders = List.of(
                new Order(OrderType.BUY, 1, 0.98),
                new Order(OrderType.BUY, 1, 0.99)
        );
        List<Order> sellOrders = List.of(
                new Order(OrderType.SELL, 1, 1.02),
                new Order(OrderType.SELL, 1, 1.01)
        );
        OrderBook orderBook = new OrderBook(buyOrders, sellOrders);
        orderBook.match(
                new Order(1, OrderType.BUY, 1),
                new Order(2, OrderType.SELL, 1)
        );
        List<Order> remainingBuyOrders = List.of(
                new Order(OrderType.BUY, 1, 0.98)
        );
        List<Order> remainingSellOrders = List.of(
                new Order(OrderType.SELL, 1, 1.02)
        );
        OrderBook expectedOrderBook = new OrderBook(remainingBuyOrders, remainingSellOrders);
        Assert.assertEquals(expectedOrderBook, orderBook);
    }
}
