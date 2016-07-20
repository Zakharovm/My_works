package databases.model;

public class PreparedDishes {
    private int id;
    private int employeeId;
    private int dishId;
    private int orderId;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PreparedDishes{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", dishId=" + dishId +
                ", orderId=" + orderId +
                ", date='" + date + '\'' +
                '}';
    }
}
