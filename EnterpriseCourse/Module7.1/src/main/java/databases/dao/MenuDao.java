package databases.dao;

import databases.model.Menu;

import java.util.List;

public interface MenuDao {

    void save (Menu menu);

    void delete (Menu menu);

    void editMenu(Menu menu);

    Menu findByName(String name);

    List<Menu> findAll();
}
