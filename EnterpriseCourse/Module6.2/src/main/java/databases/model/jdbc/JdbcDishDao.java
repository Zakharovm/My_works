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
            this.getJdbcTemplate().update("INSERT INTO DISH VALUES (?, ?, ?, ?, ?)",
                    dish.getId(),
                    dish.getName(),
                    dish.getCategory(),
                    dish.getPrice(),
                    dish.getWeight()
            );

    }

    @Override
    public void delete(int id) {
            LOGGER.info("Delete the dish from the table. ");
            this.getJdbcTemplate().update("DELETE FROM DISH WHERE id = ?", id);
    }

    @Override
    public List<Dish> find(String name) {
        List<Dish> dishList = new ArrayList<>();
        LOGGER.info("Finding the dish with specific name: " + name);
            dishList = this.getJdbcTemplate().query("SELECT * FROM DISH WHERE name = '" + name + "'",
                    new RowMapper<Dish>() {
                        @Override
                        public Dish mapRow(ResultSet rs, int rowNumber)
                                throws SQLException {
                            return getDish(rs);
                        }
                    });
        return dishList;
    }

    @Override
    public List<Dish> findAll() {
        List<Dish> dishList = new ArrayList<>();
        LOGGER.info("Selecting the dish list. ");
            dishList = this.getJdbcTemplate().query("SELECT * FROM DISH",
                    new RowMapper<Dish>() {
                        @Override
                        public Dish mapRow(ResultSet rs, int rowNumber)
                                throws SQLException {
                            return getDish(rs);
                        }
                    });
        return dishList;
    }

    private Dish getDish(ResultSet rs) throws SQLException {
        Dish dish = new Dish();
        dish.setId(rs.getInt("id"));
        dish.setName(rs.getString("name"));
        dish.setCategory(rs.getString("category"));
        dish.setPrice(rs.getFloat("price"));
        dish.setWeight(rs.getFloat("weight"));
        return dish;
    }
}
