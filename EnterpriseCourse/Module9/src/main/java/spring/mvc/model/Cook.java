package spring.mvc.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cook extends Employee {

    @OneToMany
    @JoinColumn(name = "employee_id")
    @Fetch(FetchMode.JOIN)
    private List<CookedDishes> cookedDishes;

    public List<CookedDishes> getCookedDishes() {
        return cookedDishes;
    }

    public void setCookedDishes(List<CookedDishes> cookedDishes) {
        this.cookedDishes = cookedDishes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cook{");
        sb.append("id=").append(getId());
        sb.append(", surname=").append(getSurname());
        sb.append(", name=").append(getName());
        sb.append(", prepared dishes={\n");
        try {
            cookedDishes.forEach(cookedDishes -> sb.append("   ").append(cookedDishes).append("\n"));
        } catch (NullPointerException e) {
            sb.append("[]");
        }
        sb.append("}");
        sb.append("}");
        return sb.toString();
    }
}
