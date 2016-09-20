package restaurant.formObjects;


import restaurant.model.Category;

import java.util.List;

public class DishForm {

    private Integer id;

    private String name;

    private Category category;

    private Float price;

    private Float weight;

    private List<Float> ingredientAmount;

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

    public List<Float> getIngredientAmount() {
        return ingredientAmount;
    }

    public void setIngredientAmount(List<Float> ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishForm dishForm = (DishForm) o;

        if (id != null ? !id.equals(dishForm.id) : dishForm.id != null) return false;
        if (name != null ? !name.equals(dishForm.name) : dishForm.name != null) return false;
        if (category != dishForm.category) return false;
        if (price != null ? !price.equals(dishForm.price) : dishForm.price != null) return false;
        if (weight != null ? !weight.equals(dishForm.weight) : dishForm.weight != null) return false;
        return ingredientAmount != null ? ingredientAmount.equals(dishForm.ingredientAmount) : dishForm.ingredientAmount == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (ingredientAmount != null ? ingredientAmount.hashCode() : 0);
        return result;
    }
}