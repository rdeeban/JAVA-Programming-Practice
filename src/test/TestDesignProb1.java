package test;

import org.junit.Test;
import vendingmachine.*;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class TestDesignProb1 {

    @Test
    public void testVendingMachineExactAmount() {
        User user = new User();
        VendingMachine vendingMachine = new VendingMachine();
        user.insertCoin(new Quarter(), vendingMachine);
        user.insertCoin(new Quarter(), vendingMachine);
        user.insertCoin(new Dime(), vendingMachine);
        user.insertCoin(new Dime(), vendingMachine);
        user.insertCoin(new Dime(), vendingMachine);
        user.insertCoin(new Nickel(), vendingMachine);
        user.insertCoin(new Nickel(), vendingMachine);
        Product chocolateBar = user.getProductBack(vendingMachine);
        assertEquals(chocolateBar.getClass(), ChocolateBar.class);
        Collection<Coin> change = user.getChangeBack(vendingMachine);
        assertEquals(new Nickel(), change);
    }
}
