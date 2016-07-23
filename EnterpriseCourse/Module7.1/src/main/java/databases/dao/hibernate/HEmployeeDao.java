package databases.dao.hibernate;

import databases.dao.EmployeeDao;
import databases.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


public class HEmployeeDao implements EmployeeDao {


    private static final Logger LOGGER = LoggerFactory.getLogger(HEmployeeDao.class);
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Employee> findAll() {
        LOGGER.info("Selecting the list of employees. ");
        return sessionFactory.getCurrentSession().createQuery("SELECT e FROM Employee e ORDER BY id").list();
    }


    @Override
    @Transactional
    public void save(Employee employee) {
        LOGGER.info("Adding the employee to table. " + employee.toString());
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    @Transactional
    public void delete(Employee employee) {
        LOGGER.info("Delete the employee from the table. ");
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    @Transactional
    public Employee findByName(String name) {
        LOGGER.info("Find the employee in the table by the name: " + name);
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Employee e WHERE e.name like :name");
        query.setParameter("name", name);

        return (Employee) query.uniqueResult();


    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}