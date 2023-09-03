package vendingmachine;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class VendingMachine {

    private int totalAmount;
    private final Map<String, VendingMachineProduct> productCodeToVendingMachineProductMap;

    public VendingMachine() {
        totalAmount = 0;
        productCodeToVendingMachineProductMap = new HashMap<>();
        productCodeToVendingMachineProductMap.put("A", new VendingMachineProduct(new Chocolate("Hershey Bar"), 85));
        productCodeToVendingMachineProductMap.put("B", new VendingMachineProduct(new Candy("Gummy Bears"), 80));
        productCodeToVendingMachineProductMap.put("C", new VendingMachineProduct(new ColdDrink("Coca-Cola"), 74));
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public String getProductCode(String productName) throws OutOfStockException {
        for (Map.Entry<String, VendingMachineProduct> productCodeToVendingMachineProductMapEntry : productCodeToVendingMachineProductMap.entrySet()) {
            if (productCodeToVendingMachineProductMapEntry.getValue().getProduct().getProductName().equals(productName)) {
                return productCodeToVendingMachineProductMapEntry.getKey();
            }
        }

        throw new OutOfStockException(String.format("%s out of stock", productName));
    }

    public void acceptCoin(Coin coin) {
        totalAmount += coin.getAmount();
    }

    public Product dispenseProduct(String productCode) throws NotEnoughMoneyException {
        VendingMachineProduct vendingMachineProduct = productCodeToVendingMachineProductMap.get(productCode);
        Product product = vendingMachineProduct.getProduct();
        int price = vendingMachineProduct.getPrice();
        if (totalAmount >= price) {
            totalAmount -= price;
            return product;
        } else {
            throw new NotEnoughMoneyException(product, price);
        }
    }

    public Collection<Coin> dispenseChange() {
        Collection<Coin> coins = new HashSet<>();
        while (totalAmount > 0) {
            if (totalAmount >= 25) {
                coins.add(new Quarter());
                totalAmount -= 25;
            }
            else if (totalAmount >= 10) {
                coins.add(new Dime());
                totalAmount -= 10;
            }
            else if (totalAmount >= 5) {
                coins.add(new Nickel());
                totalAmount -= 5;
            }
            else {
                coins.add(new Cent());
                totalAmount -= 1;
            }
        }

        return coins;
    }

    public int getProductPrice(String productCode) {
        return productCodeToVendingMachineProductMap.get(productCode).getPrice();
    }

    private static class VendingMachineProduct {
        private final Product product;
        private final int price;

        public VendingMachineProduct(Product product, int price) {
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
}
