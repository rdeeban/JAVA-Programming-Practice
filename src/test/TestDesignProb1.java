package test;

import org.junit.Before;
import org.junit.Test;
import vendingmachine.*;

import java.util.Collection;

import static org.junit.Assert.*;

public class TestDesignProb1 {

    private User user;
    private VendingMachine vendingMachine;

    @Before
    public void setupUserAndVendingMachine() {
        user = new User();
        vendingMachine = new VendingMachine();
    }

    @Test
    public void testUserInsertsCoinsWorthNinetyCentsAndGetsBackHersheyBarChocolateAndFiveCents() {
        user.insertCoin(new Quarter(), vendingMachine); // 25 cents
        user.insertCoin(new Quarter(), vendingMachine); // 50 cents
        user.insertCoin(new Dime(), vendingMachine); // 60 cents
        user.insertCoin(new Dime(), vendingMachine); // 70 cents
        user.insertCoin(new Dime(), vendingMachine); // 80 cents
        user.insertCoin(new Nickel(), vendingMachine); // 85 cents
        user.insertCoin(new Nickel(), vendingMachine); // 90 cents
        String productName = "Hershey Bar";
        String productCode = user.seeProductCode(vendingMachine, productName);
        Product chocolate = user.getProductBack(vendingMachine, productCode);
        assertEquals(productName, chocolate.getProductName());
        Collection<Coin> change = user.getChangeBack(vendingMachine);
        int price = user.askPrice(vendingMachine, productCode);
        assertEquals(90 - price, calculateAmount(change));
    }

    @Test
    public void testUserInsertsCoinsWorthNinetyCentsAndGetsBackGummyBearsCandyAndFiveCents() {
        user.insertCoin(new Quarter(), vendingMachine); // 25 cents
        user.insertCoin(new Quarter(), vendingMachine); // 50 cents
        user.insertCoin(new Dime(), vendingMachine); // 60 cents
        user.insertCoin(new Dime(), vendingMachine); // 70 cents
        user.insertCoin(new Dime(), vendingMachine); // 80 cents
        user.insertCoin(new Nickel(), vendingMachine); // 85 cents
        user.insertCoin(new Nickel(), vendingMachine); // 90 cents
        String productName = "Gummy Bears";
        String productCode = user.seeProductCode(vendingMachine, productName);
        Product chocolate = user.getProductBack(vendingMachine, productCode);
        assertEquals(productName, chocolate.getProductName());
        Collection<Coin> change = user.getChangeBack(vendingMachine);
        int price = user.askPrice(vendingMachine, productCode);
        assertEquals(90 - price, calculateAmount(change));
    }

    @Test
    public void testUserInsertsNinetyCentsAndGetsBackCocaColaColdDrinkAndDime() {
        user.insertCoin(new Quarter(), vendingMachine); // 25 cents
        user.insertCoin(new Quarter(), vendingMachine); // 50 cents
        user.insertCoin(new Dime(), vendingMachine); // 60 cents
        user.insertCoin(new Dime(), vendingMachine); // 70 cents
        user.insertCoin(new Dime(), vendingMachine); // 80 cents
        user.insertCoin(new Nickel(), vendingMachine); // 85 cents
        user.insertCoin(new Nickel(), vendingMachine); // 90 cents
        String productName = "Coca Cola";
        String productCode = user.seeProductCode(vendingMachine, productName);
        Product chocolate = user.getProductBack(vendingMachine, productCode);
        assertEquals(productName, chocolate.getProductName());
        Collection<Coin> change = user.getChangeBack(vendingMachine);
        int price = user.askPrice(vendingMachine, productCode);
        assertEquals(90 - price, calculateAmount(change));
    }

    private int calculateAmount(Collection<Coin> change) {
        int amount = 0;
        for (Coin coin : change) {
            amount += coin.getAmount();
        }

        return amount;
    }
}
