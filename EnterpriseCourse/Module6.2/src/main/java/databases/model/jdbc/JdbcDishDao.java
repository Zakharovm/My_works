package databases.model.jdbc;

import databases.model.Dish;
import databases.model.DishDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcDishDao extends JdbcDaoSupport implements DishDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcDishDao.class);

    @Override
    public void add(Dish dish) {
        LOGGER.info("Adding the dish to table. " + dish.toString());
        try {
            this.getJdbcTemplate().update("INSERT INTO DISH VALUES (?, ?, ?, ?, ?)",
                    dish.getId(),
                    dish.getName(),
                    dish.getMenuId(),
                    dish.getPrice(),
                    dish.getWeight()
            );
        } catch (Exception e) {
            LOGGER.error("Error occurred, while adding dish " + dish.toString());
            throw new RuntimeException();

        }
    }

    @Override
    public void delete(int id) {
        try {
            LOGGER.info("Delete the dish from the table. ");
            this.getJdbcTemplate().update("DELETE FROM DISH WHERE id = ?", id);
        } catch (Exception e) {
            LOGGER.error("Error occurred, while adding dish with id " + id);
        }


    }

    @Override
    public List<Dish> find(String name) {
        List<Dish> dishList = new ArrayList<>();
        LOGGER.info("Finding the dish with specific name: " + name);
        try {
            dishList = this.getJdbcTemplate().query("SELECT * FROM DISH WHERE name = '" + name + "'",
                    new RowMapper<Dish>() {
                        @Override
                        public Dish mapRow(ResultSet rs, int rowNumber)
                                throws SQLException {
                            return getDish(rs);
                        }
                    });
        } catch (Exception e) {
            LOGGER.error("Error occurred, while finding dish with the name" + name);
        }
        return dishList;
    }

    @Override
    public List<Dish> findAll() {
        List<Dish> dishList = new ArrayList<>();
        LOGGER.info("Selecting the dish list. ");
        try {
            dishList = this.getJdbcTemplate().query("SELECT * FROM DISH",
                    new RowMapper<Dish>() {
                        @Override
                        public Dish mapRow(ResultSet rs, int rowNumber)
                                throws SQLException {
                            return getDish(rs);
                        }
                    });
        } catch (Exception e) {
            LOGGER.error("Error occurred, during the output of the dish list. ");

        }
        return dishList;
    }

    private Dish getDish(ResultSet rs) throws SQLException {
        Dish dish = new Dish();
        dish.setId(rs.getInt("id"));
        dish.setName(rs.getString("name"));
        dish.setMenuId(rs.getInt("menu_id"));
        dish.setPrice(rs.getFloat("price"));
        dish.setWeight(rs.getFloat("weight"));
        return dish;
    }
}
