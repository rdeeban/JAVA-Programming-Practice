package vendingmachine;

import java.util.Collection;

public class User {
    public void insertCoin(Coin coin, VendingMachine vendingMachine) {
        vendingMachine.acceptCoin(coin);
    }

    public int askPrice(VendingMachine vendingMachine, String productCode) {
        return vendingMachine.getProductPrice(productCode);
    }

    public Product getProductBack(VendingMachine vendingMachine, String productCode) {
        try {
            return vendingMachine.dispenseProduct(productCode);
        } catch (NotEnoughMoneyException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<Coin> getChangeBack(VendingMachine vendingMachine) {
        return vendingMachine.dispenseChange();
    }

    public String seeProductCode(VendingMachine vendingMachine, String productName) {
        try {
            return vendingMachine.getProductCode(productName);
        } catch (OutOfStockException e) {
            throw new RuntimeException(e);
        }
    }
}
