package databases.exceptions;

public class ClosedOrderException extends Throwable {
    private int orderId;

    public ClosedOrderException(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
}
