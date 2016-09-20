package restaurant.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import restaurant.dao.EmployeeDao;
import restaurant.model.Employee;
import restaurant.model.Position;

import java.util.List;

public class HEmployeeDao implements EmployeeDao {


    private static final Logger LOGGER = LoggerFactory.getLogger(HEmployeeDao.class);
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveOrUpdate(Employee employee) {
        LOGGER.info("Adding the employee to table. " + employee.toString());
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }


    @Override
    @Transactional
    public List<Employee> findAll() {
        LOGGER.info("Selecting the list of employees. ");
        return sessionFactory.getCurrentSession().createQuery("SELECT e FROM Employee e ORDER BY id").list();
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

    @Override
    @Transactional
    public Employee findBySurname(String surname) {
        LOGGER.info("Find the employee in the table by the surname: " + surname);
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Employee e WHERE e.surname like :surname");
        query.setParameter("surname", surname);

        return (Employee) query.uniqueResult();
    }

    @Override
    @Transactional
    public Employee findById(Integer id) {
        LOGGER.info("Find the employee in the table by the id: " + id);
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Employee e WHERE e.id = :id");
        query.setParameter("id", id);

        return (Employee) query.uniqueResult();

    }

    @Override
    @Transactional
    public Employee findByNameSurname(String name, String surname) {
        LOGGER.info("Find the employee in the table by the name and surname: " + name + ", " + surname);
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Employee e WHERE e.name like :name AND e.surname like :surname");
        query.setParameter("name", name).setParameter("surname", surname);

        return (Employee) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Employee> getEmployeeByPosition(Position position) {
        LOGGER.info("Find the employee in the table by the position: " + position);
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT e FROM Employee e WHERE e.position like :position ORDER BY id").setParameter("position", position).list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}