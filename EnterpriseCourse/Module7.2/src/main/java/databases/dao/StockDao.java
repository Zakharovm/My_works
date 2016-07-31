package databases.dao;

import databases.model.Stock;

import java.util.List;

public interface StockDao {

    void save(Stock stock);

    void delete(Stock stock);

    void edit(Stock stock);

    Stock findByName(String name);

    List<Stock> findAll();

    List<Stock> findPaucity();

}
