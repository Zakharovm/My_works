package databases.model;

public class Menu {

    private int id;
    private int categoryId;
    private int dishId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", dishId=" + dishId +
                '}';
    }
}
