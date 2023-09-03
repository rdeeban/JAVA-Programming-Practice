package vendingmachine;

import java.util.Collection;

public class User {
    public void insertCoin(Coin coin, VendingMachine vendingMachine) {
        vendingMachine.acceptCoin(coin);
    }

    public int askPrice(VendingMachine vendingMachine, String productCode) {
        return vendingMachine.getProductPrice(productCode);
    }

    public Product getProductBack(VendingMachine vendingMachine, String productCode) throws UserNeedsToInsertMoreMoneyException {
        try {
            return vendingMachine.dispenseProduct(productCode);
        } catch (NotEnoughMoneyException notEnoughMoneyException) {
            Product product = notEnoughMoneyException.getProduct();
            int price = notEnoughMoneyException.getPrice();
            int totalAmount = vendingMachine.getTotalAmount();
            int balance = price - totalAmount;
            String productName = product.getProductName();
            throw new UserNeedsToInsertMoreMoneyException(String.format("User needs to insert %d more cents to buy %s", balance, productName));
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
