package restaurant.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
//@FilterDef(name = "orderDateFilter", parameters = @ParamDef(name = "dateFilter", type = "java.util.Date"))
//@FilterDef(name = "orderWaiterFilter", parameters = @ParamDef(name = "waiterId", type = "java.lang.Integer"))
//@FilterDef(name = "orderTableFilter", parameters = @ParamDef(name = "tableNumber", type = "java.lang.Integer"))

//@Filter(name = "orderDateFilter", condition = "date_of_order = :dateFilter")
//@Filter(name = "orderWaiterFilter", condition = "employee_id = :waiterId")
//@Filter(name = "orderTableFilter", condition = "table_number = :tableNumber")

public class Orders {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Waiter waiter;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_to_dish",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Dish> dishes;

    @Column(name = "table_number")
    private Integer tableNumber;

    @Column(name = "date_of_order")
    private Date dateOfOrder;

    @Column(name = "current_status")
    @Enumerated(EnumType.STRING)
    private Status currentStatus;

    public boolean isNew() {
        return this.id == null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", dishes=" + dishes +
                ", tableNumber=" + tableNumber +
                ", dateOfOrder=" + dateOfOrder +
                ", currentStatus=" + currentStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != null ? !id.equals(orders.id) : orders.id != null) return false;
        if (waiter != null ? !waiter.equals(orders.waiter) : orders.waiter != null) return false;
        if (dishes != null ? !dishes.equals(orders.dishes) : orders.dishes != null) return false;
        if (tableNumber != null ? !tableNumber.equals(orders.tableNumber) : orders.tableNumber != null) return false;
        if (dateOfOrder != null ? !dateOfOrder.equals(orders.dateOfOrder) : orders.dateOfOrder != null) return false;
        return currentStatus == orders.currentStatus;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (waiter != null ? waiter.hashCode() : 0);
        result = 31 * result + (dishes != null ? dishes.hashCode() : 0);
        result = 31 * result + (tableNumber != null ? tableNumber.hashCode() : 0);
        result = 31 * result + (dateOfOrder != null ? dateOfOrder.hashCode() : 0);
        result = 31 * result + (currentStatus != null ? currentStatus.hashCode() : 0);
        return result;
    }
}
