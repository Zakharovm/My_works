package restaurant.formObjects;

public class TableNumberForm {

    private Integer tableNumber;

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableNumberForm that = (TableNumberForm) o;

        return tableNumber != null ? tableNumber.equals(that.tableNumber) : that.tableNumber == null;

    }

    @Override
    public int hashCode() {
        return tableNumber != null ? tableNumber.hashCode() : 0;
    }
}
