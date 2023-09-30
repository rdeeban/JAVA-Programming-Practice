package limitorderbook;

import java.util.*;
import limitorderbook.Order.OrderType;

public class OrderBook {

    private Map<OrderType, LinkedList<OrderBookEntry>> orderBook;

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
        public boolean equals(Object o) {
            return orderType == ((OrderBookEntry) o).orderType &&
                    price == ((OrderBookEntry) o).price &&
                    size == ((OrderBookEntry) o).size;
        }

        @Override
        public int compareTo(OrderBookEntry orderBookEntry) {
            if (orderBookEntry.orderType == OrderType.BUY) {
                return (int) (-(price - orderBookEntry.price) * 100);
            } else {
                return (int) ((price - orderBookEntry.price) * 100);
            }
        }
    }

    public OrderBook(List<Order> buyOrders, List<Order> sellOrders) {
        List<OrderBookEntry> orderBookEntriesBuyOrders = new ArrayList<>();
        for (Order order : buyOrders) {
            OrderBookEntry.OrderType orderBookEntryOrderType = OrderBookEntry.OrderType.BUY;
            orderBookEntriesBuyOrders.add(new OrderBookEntry(orderBookEntryOrderType, order.getPrice(), order.getSize()));
        }

        Collections.sort(orderBookEntriesBuyOrders);
        orderBook = new HashMap<>();
        orderBook.put(OrderType.BUY, new LinkedList<>(orderBookEntriesBuyOrders));
        List<OrderBookEntry> orderBookEntriesSellOrders = new ArrayList<>();
        for (Order order : sellOrders) {
            OrderBookEntry.OrderType orderBookEntryOrderType = OrderBookEntry.OrderType.SELL;
            orderBookEntriesSellOrders.add(new OrderBookEntry(orderBookEntryOrderType, order.getPrice(), order.getSize()));
        }

        Collections.sort(orderBookEntriesSellOrders);
        orderBook.put(OrderType.SELL, new LinkedList<>(orderBookEntriesSellOrders));
    }

    public void match(Order... orders) {
        Arrays.sort(orders);
        for (Order order : orders) {
            String orderTypeName;
            LinkedList<OrderBookEntry> orderBookEntries;
            if (order.getOrderType() == Order.OrderType.BUY) {
                orderTypeName = "BUY";
                orderBookEntries = orderBook.get(OrderType.SELL);
            } else if (order.getOrderType() == Order.OrderType.SELL) {
                orderTypeName = "SELL";
                orderBookEntries = orderBook.get(OrderType.BUY);
            } else {
                throw new RuntimeException("Unknown order type.");
            }

            int currentOrderSize = order.getSize();
            double currentOrderPrice = order.getPrice();
            do {
                OrderBookEntry currentOrderBookEntry;
                try {
                    currentOrderBookEntry = orderBookEntries.getFirst();
                } catch (NoSuchElementException e) {
                    throw new RuntimeException(String.format("No more %s order book entries to match the order.",
                            orderTypeName));
                }

                currentOrderSize -= currentOrderBookEntry.size;
                if (currentOrderSize <= 0) {
                    orderBookEntries.removeFirst();
                } else {
                    currentOrderSize = -currentOrderSize;
                }
            } while (currentOrderSize > 0);
        }
    }

    @Override
    public boolean equals(Object o) {
        LinkedList<OrderBookEntry> buyOrders = orderBook.get(OrderType.BUY);
        LinkedList<OrderBookEntry> otherBuyOrders = ((OrderBook) o).orderBook.get(OrderType.BUY);
        LinkedList<OrderBookEntry> sellOrders = orderBook.get(OrderType.SELL);
        LinkedList<OrderBookEntry> otherSellOrders = ((OrderBook) o).orderBook.get(OrderType.SELL);
        return buyOrders.equals(otherBuyOrders) && sellOrders.equals(otherSellOrders);
    }
}
