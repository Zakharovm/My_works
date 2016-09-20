package restaurant.dao;

import restaurant.model.Menu;

import java.util.List;

public interface MenuDao {

    void saveOrUpdate(Menu menu);

    void delete(Menu menu);

    Menu findByName(String name);

    Menu findById(Integer id);

    List<Menu> findAll();

}
