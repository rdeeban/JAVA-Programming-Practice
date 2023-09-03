package test;

import org.junit.Before;
import org.junit.Test;
import vendingmachine.*;

import java.util.Arrays;
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
    public void testUserInsertsNinetyCentsAndGetsBackHersheyBarChocolateAndFiveCents() throws UserNeedsToInsertMoreMoneyException {
        Collection<Coin> wallet = Arrays.asList(
                new Quarter(), // 25 cents
                new Quarter(), // 50 cents
                new Dime(), // 60 cents
                new Dime(), // 70 cents
                new Dime(), // 80 cents
                new Nickel(), // 85 cents
                new Nickel() // 90 cents
        );

        for (Coin coin : wallet) {
            user.insertCoin(coin, vendingMachine);
        }

        String productName = "Hershey Bar";
        String productCode = user.seeProductCode(vendingMachine, productName);
        Product chocolate = user.getProductBack(vendingMachine, productCode);
        assertEquals(productName, chocolate.getProductName());
        Collection<Coin> change = user.getChangeBack(vendingMachine);
        int price = user.askPrice(vendingMachine, productCode);
        assertEquals(90 - price, calculateAmount(change));
    }

    @Test
    public void testUserInsertsNinetyCentsAndGetsBackGummyBearsCandyAndFiveCents() throws UserNeedsToInsertMoreMoneyException {
        Collection<Coin> wallet = Arrays.asList(
                new Quarter(), // 25 cents
                new Quarter(), // 50 cents
                new Dime(), // 60 cents
                new Dime(), // 70 cents
                new Dime(), // 80 cents
                new Nickel(), // 85 cents
                new Nickel() // 90 cents
        );

        for (Coin coin : wallet) {
            user.insertCoin(coin, vendingMachine);
        }

        String productName = "Gummy Bears";
        String productCode = user.seeProductCode(vendingMachine, productName);
        Product chocolate = user.getProductBack(vendingMachine, productCode);
        assertEquals(productName, chocolate.getProductName());
        Collection<Coin> change = user.getChangeBack(vendingMachine);
        int price = user.askPrice(vendingMachine, productCode);
        assertEquals(90 - price, calculateAmount(change));
    }

    @Test
    public void testUserInsertsNinetyCentsAndGetsBackCocaColaColdDrinkAndDime() throws UserNeedsToInsertMoreMoneyException {
        Collection<Coin> wallet = Arrays.asList(
                new Quarter(), // 25 cents
                new Quarter(), // 50 cents
                new Dime(), // 60 cents
                new Dime(), // 70 cents
                new Dime(), // 80 cents
                new Nickel(), // 85 cents
                new Nickel() // 90 cents
        );

        for (Coin coin : wallet) {
            user.insertCoin(coin, vendingMachine);
        }

        String productName = "Coca-Cola";
        String productCode = user.seeProductCode(vendingMachine, productName);
        Product chocolate = user.getProductBack(vendingMachine, productCode);
        assertEquals(productName, chocolate.getProductName());
        Collection<Coin> change = user.getChangeBack(vendingMachine);
        int price = user.askPrice(vendingMachine, productCode);
        assertEquals(90 - price, calculateAmount(change));
    }

    @Test
    public void testUserInsertsSeventyCentsAndNeedsToInsertFourMoreCentsToGetBackCocaColaColdDrink() {
        Collection<Coin> wallet = Arrays.asList(
                new Quarter(), // 25 cents
                new Quarter(), // 50 cents
                new Dime(), // 60 cents
                new Dime() // 70 cents
        );

        for (Coin coin : wallet) {
            user.insertCoin(coin, vendingMachine);
        }

        String productName = "Coca-Cola";
        String productCode = user.seeProductCode(vendingMachine, productName);
        UserNeedsToInsertMoreMoneyException userNeedsToInsertMoreMoneyException = assertThrows(UserNeedsToInsertMoreMoneyException.class, () -> user.getProductBack(vendingMachine, productCode));
        assertEquals("User needs to insert 4 more cents to buy Coca-Cola", userNeedsToInsertMoreMoneyException.getMessage());
    }

    private int calculateAmount(@org.jetbrains.annotations.NotNull Collection<Coin> change) {
        int amount = 0;
        for (Coin coin : change) {
            amount += coin.getAmount();
        }

        return amount;
    }
}
