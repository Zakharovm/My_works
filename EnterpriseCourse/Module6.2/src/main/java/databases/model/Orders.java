package databases.model;

public class Orders {

    private int id;
    private int EmployeeId;
    private int tableNumber;
    private String dateOfOrder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", EmployeeId=" + EmployeeId +
                ", tableNumber=" + tableNumber +
                ", dateOfOrder='" + dateOfOrder + '\'' +
                '}';
    }
}
