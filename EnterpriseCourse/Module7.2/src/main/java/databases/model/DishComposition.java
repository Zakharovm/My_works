package databases.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Dish_composition")
public class DishComposition implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Id
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(name = "amount")
    private Float amount;

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "DishComposition{" +
                "dish=" + dish +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                '}';
    }
}
