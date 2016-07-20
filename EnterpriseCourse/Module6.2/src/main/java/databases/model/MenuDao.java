package databases.model;

import java.util.List;

public interface MenuDao {

    void add(Menu menu);

    void delete(int id);

    void addDishToMenu();

    void deleteDishFromMenu();

    List<Menu> find(String name);

    List<Menu> findAll();





}
