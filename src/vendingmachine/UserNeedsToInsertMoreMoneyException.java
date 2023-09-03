package vendingmachine;

public class UserNeedsToInsertMoreMoneyException extends Throwable {
    public UserNeedsToInsertMoreMoneyException(String message) {
        super(message);
    }
}
