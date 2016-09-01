package spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.mvc.model.Employee;
import spring.mvc.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Employee> employee() {

        return employeeService.getEmployees();
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee employee(@PathVariable Integer id) {

        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = "/employee/{name}", method = RequestMethod.GET)
    public Employee employeeName(@PathVariable String name) {

        return employeeService.getEmployeeByName(name);
    }

    @RequestMapping(value = "/employee/{surname}", method = RequestMethod.GET)
    public Employee employeeSurname(@PathVariable String surname) {

        return employeeService.getEmployeeBySurname(surname);
    }

    @RequestMapping(value = "/employee/{name}_{surname}", method = RequestMethod.GET)
    public Employee employeeSurname(@PathVariable String name, @PathVariable String surname) {

        return employeeService.getEmployeeByNameSurname(name, surname);
    }


    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
