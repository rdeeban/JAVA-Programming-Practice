package vendingmachine;

import java.util.Collection;

public class User {
    public void insertCoin(Coin coin, VendingMachine vendingMachine) {
        // todo: implement this function
        vendingMachine.acceptCoin(coin);
        throw new UnsupportedOperationException("Inserting a coin is not supported yet.");
    }

    public Product getProductBack(VendingMachine vendingMachine) {
        // todo: implement this function
        throw new UnsupportedOperationException("Getting a product back is not supported yet.");
    }

    public Collection<Coin> getChangeBack(VendingMachine vendingMachine) {
        // todo: implement this function
        throw new UnsupportedOperationException("Getting change back is not supported yet.");
    }
}
