package databases.model.jdbc;

import databases.model.Employee;
import databases.model.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class JdbcEmployeeDao extends JdbcDaoSupport implements EmployeeDao {


    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcEmployeeDao.class);

    @Override
    public List<Employee> findAll() {
        LOGGER.info("Selecting the employee list. ");

        List<Employee> employeeList = this.getJdbcTemplate().query("SELECT * FROM EMPLOYEE",
                new RowMapper<Employee>() {
                    @Override
                    public Employee mapRow(ResultSet rs, int rowNumber)
                            throws SQLException {
                        return getEmployee(rs);
                    }
                });
        return employeeList;
    }


    @Override
    public void add(Employee employee) {
        LOGGER.info("Adding the employee to table. ");
        try {
            this.getJdbcTemplate().update("INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?, ?, ?, ?)",
                    employee.getId(),
                    employee.getSurname(),
                    employee.getName(),
                    employee.getDateOfBirth(),
                    employee.getPhoneNumber(),
                    employee.getPositionId(),
                    employee.getSalary()
            );
        } catch (Exception e) {
            LOGGER.error("Error occurred, while adding employee " + employee.toString());
            throw new RuntimeException();

        }


    }

    @Override
    public void delete(int id) {
        LOGGER.info("Delete the employee from the table. ");
        try {
            this.getJdbcTemplate().update("DELETE FROM EMPLOYEE WHERE id = ?", id);
        } catch (Exception e) {
            LOGGER.error("Error occurred, while adding employee with id " + id);
            throw new RuntimeException();

        }


    }

    @Override
    public List<Employee> find(String name) {
        LOGGER.info("Find the employee in the table by the name: " + name);

        List<Employee> employeeList = this.getJdbcTemplate().query("SELECT * FROM EMPLOYEE WHERE name = '" + name + "'",
                new RowMapper<Employee>() {
                    @Override
                    public Employee mapRow(ResultSet rs, int rowNumber)
                            throws SQLException {
                        return getEmployee(rs);
                    }
                });
        return employeeList;


    }

    private Employee getEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setSurname(rs.getString("surname"));
        employee.setName(rs.getString("name"));
        employee.setDateOfBirth(rs.getString("date_of_birth"));
        employee.setPhoneNumber(rs.getString("phone_number"));
        employee.setPositionId(rs.getInt("position_id"));
        employee.setSalary(rs.getFloat("salary"));
        return employee;
    }
}