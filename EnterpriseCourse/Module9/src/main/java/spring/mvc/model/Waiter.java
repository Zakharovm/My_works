package spring.mvc.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Waiter extends Employee {

    @OneToMany
    @JoinColumn(name = "employee_id")
    @Fetch(FetchMode.JOIN)
    private List<Orders> orders;

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Waiter{");
        sb.append("id=").append(getId());
        sb.append(", surname=").append(getSurname());
        sb.append(", name=").append(getName());
        sb.append(", orders={\n");
        try {
            orders.forEach(order -> sb.append("   ").append(order).append("\n"));
        } catch (NullPointerException e) {
            sb.append("[]");
        }
        sb.append("}}");
        return sb.toString();
    }
}
