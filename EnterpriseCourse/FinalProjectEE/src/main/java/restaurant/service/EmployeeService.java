package restaurant.service;

import org.springframework.transaction.annotation.Transactional;
import restaurant.model.Employee;
import restaurant.dao.EmployeeDao;
import restaurant.model.Position;
import restaurant.model.Waiter;
import restaurant.service.dao.EmployeeServiceDao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeService implements EmployeeServiceDao {

    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void saveOrUpdate(Employee employee) {
        employeeDao.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        employeeDao.delete(findById(id));
    }

    @Override
    @Transactional
    public Employee findById(Integer id) {
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public Employee findByName(String employeeName) {
        return employeeDao.findByName(employeeName);
    }

    @Override
    @Transactional
    public Employee findBySurname(String surname) {
        return employeeDao.findBySurname(surname);
    }

    @Override
    @Transactional
    public Employee findByNameSurname(String name, String surname) {
        return employeeDao.findByNameSurname(name, surname);
    }

    @Override
    @Transactional
    public Set<Position> getAllPositions() {
        Set<Position> positions = new TreeSet<>();
        List<Employee> employees = employeeDao.findAll();
        employees.forEach(employee -> positions.add(employee.getPosition()));
        return positions;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public List<Employee> findAllWaiters() {
        return employeeDao.getEmployeeByPosition(Position.Waiter);
    }

    @Override
    @Transactional
    public Waiter findWaiterByName(String name) {
        for (Employee employee: this.findAllWaiters()) {
            if (employee.getName().equals(name)) {
                return (Waiter) employee;
            }
        }
        return null;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
