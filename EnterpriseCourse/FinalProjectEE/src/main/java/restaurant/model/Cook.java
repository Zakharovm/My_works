package restaurant.model;

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

        }
        sb.append("}");
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cook cook = (Cook) o;

        return cookedDishes != null ? cookedDishes.equals(cook.cookedDishes) : cook.cookedDishes == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (cookedDishes != null ? cookedDishes.hashCode() : 0);
        return result;
    }
}
