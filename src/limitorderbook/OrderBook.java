package limitorderbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OrderBook {

    LinkedList<OrderBookEntry> askPrices;
    LinkedList<OrderBookEntry> bidPrices;

    private static class OrderBookEntry implements Comparable<OrderBookEntry> {

        public enum OrderType { BUY, SELL }

        private OrderType orderType;

        private double price;

        private int size;

        public OrderBookEntry (OrderType orderType, double price, int size) {
            this.orderType = orderType;
            this.price = price;
            this.size = size;
        }

        @Override
        public int compareTo(OrderBookEntry o) {
            return (int) ((price - o.price) * 100);
        }
    }

    public OrderBook(List<Order> sellOrders, List<Order> buyOrders) {
        List<OrderBookEntry> orderBookEntriesSellOrders = new ArrayList<>();
        for (Order order : sellOrders) {
            OrderBookEntry.OrderType orderBookEntryOrderType = OrderBookEntry.OrderType.SELL;
            double price = order.getPrice();
            int size = order.getSize();
            orderBookEntriesSellOrders.add(new OrderBookEntry(orderBookEntryOrderType, price, size));
        }

        Collections.sort(orderBookEntriesSellOrders);
        bidPrices = new LinkedList<>(orderBookEntriesSellOrders);
        List<OrderBookEntry> orderBookEntriesBuyOrders = new ArrayList<>();
        for (Order order : buyOrders) {
            OrderBookEntry.OrderType orderBookEntryOrderType = OrderBookEntry.OrderType.BUY;
            double price = order.getPrice();
            int size = order.getSize();
            orderBookEntriesBuyOrders.add(new OrderBookEntry(orderBookEntryOrderType, price, size));
        }

        Collections.sort(orderBookEntriesBuyOrders);
        askPrices = new LinkedList<>(orderBookEntriesBuyOrders);
    }

    public void match(Order... orders) {

    }
}
