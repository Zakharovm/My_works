package restaurant.service;

import org.springframework.transaction.annotation.Transactional;
import restaurant.dao.CookedDishesDao;
import restaurant.model.CookedDishes;
import restaurant.service.dao.CookedDishesServiceDao;

public class CookedDishesService implements CookedDishesServiceDao {

    private CookedDishesDao cookedDishesDao;

    @Override
    @Transactional
    public CookedDishes findById(Integer id) {
        return cookedDishesDao.findById(id);
    }

    public void setCookedDishesDao(CookedDishesDao cookedDishesDao) {
        this.cookedDishesDao = cookedDishesDao;
    }
}
