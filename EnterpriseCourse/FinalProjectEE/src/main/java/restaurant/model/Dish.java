package restaurant.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "price")
    private Float price;

    @Column(name = "weight")
    private Float weight;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "dish_composition")
    @MapKeyJoinColumn(name = "ingredient_id")
    @Column(name = "amount")
    private Map<Ingredient, Float> composition;


    public Dish() {
        this.composition = new HashMap<Ingredient, Float>();
    }

    public boolean isNew() {
        return (this.id == null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Map<Ingredient, Float> getComposition() {
        return composition;
    }

    public void setComposition(Map<Ingredient, Float> composition) {
        this.composition = composition;
    }

    public void setIngredientAmount(Ingredient ingredient, Float amount) {
        composition.put(ingredient, amount);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Dish {");
        stringBuilder.append("id=");
        stringBuilder.append(id);
        stringBuilder.append(", name=");
        stringBuilder.append(name);
        stringBuilder.append(", category=");
        stringBuilder.append(category);
        stringBuilder.append(", price=");
        stringBuilder.append(price);
        stringBuilder.append(", weight=");
        stringBuilder.append(weight);
        stringBuilder.append(", composition={");
        composition.forEach((k,v)->stringBuilder.append(k + ", amount=" + v + "}"));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (id != null ? !id.equals(dish.id) : dish.id != null) return false;
        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        if (category != dish.category) return false;
        if (price != null ? !price.equals(dish.price) : dish.price != null) return false;
        if (weight != null ? !weight.equals(dish.weight) : dish.weight != null) return false;
        return composition != null ? composition.equals(dish.composition) : dish.composition == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (composition != null ? composition.hashCode() : 0);
        return result;
    }
}
