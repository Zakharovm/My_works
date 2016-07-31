package databases.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "Dish")
public class Dish {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}
