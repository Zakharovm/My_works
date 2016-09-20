package restaurant.exceptions;

public class ClosedOrderException extends Throwable {
    private Integer orderId;

    public ClosedOrderException(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }
}
