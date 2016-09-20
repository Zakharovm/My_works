package restaurant.controllers.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import restaurant.formObjects.EmployeeForm;
import restaurant.model.*;
import restaurant.service.dao.CookedDishesServiceDao;
import restaurant.service.dao.EmployeeServiceDao;
import restaurant.service.dao.OrderServiceDao;
import restaurant.validator.EmployeeFormValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(DishController.class);

    private EmployeeServiceDao employeeServiceDao;

    private OrderServiceDao orderServiceDao;

    private CookedDishesServiceDao cookedDishesServiceDao;

    @Autowired
    EmployeeFormValidator employeeFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(employeeFormValidator);
        binder.registerCustomEditor(Float.class, new CustomNumberEditor(Float.class, false));
    }

    @RequestMapping(value = "/admin/employees", method = RequestMethod.GET)
    public ModelAndView getEmployees() {
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> employeeList = employeeServiceDao.getAllEmployees();
        if (employeeList == null) {
            throw new EmptyResultDataAccessException(10);
        } else {
            modelAndView.addObject("employeeList", employeeList);
        }

        modelAndView.setViewName("admin/employees");
        return modelAndView;
    }

    //saveOrUpdate or update page
    @RequestMapping(value = "/admin/employees", method = RequestMethod.POST)
    public String saveOrUpdateEmployee(@ModelAttribute("employeeForm") @Validated EmployeeForm employeeForm,
                                       BindingResult result, final RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {
            populateDefaultModel(model);
            return "admin/employeeForm";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if (employeeForm.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "Employee added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "Employee updated successfully!");
            }

            Employee employee;

            employee = convertEmployeeFormToEmployee(employeeForm);

            employeeServiceDao.saveOrUpdate(employee);

            return "redirect:/admin/employees/" + employee.getId();


        }

    }

    // show add user form
    @RequestMapping(value = "/admin/employees/add", method = RequestMethod.GET)
    public String showAddEmployeeForm(Model model) {
        logger.debug("showAddEmployeeForm()");
        EmployeeForm employeeForm = new EmployeeForm();

        populateDefaultModel(model);

        model.addAttribute("employeeForm", employeeForm);
        return "admin/employeeForm";
    }

    @RequestMapping(value = "/admin/employees/{id}/update", method = RequestMethod.GET)
    public String showUpdateEmployeeForm(@PathVariable("id") Integer id, Model model) {

        EmployeeForm employeeForm = (id == null ? new EmployeeForm() : convertEmployeeToEmployeeForm(employeeServiceDao.findById(id)));


        model.addAttribute("employeeForm", employeeForm);

        populateDefaultModel(model);

        return "admin/employeeForm";
    }

    @RequestMapping(value = "/admin/employees/{id}/delete", method = RequestMethod.POST)
    public String deleteEmployee(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {

        logger.debug("deleteEmployee() : {}", id);

        employeeServiceDao.delete(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Employee is deleted!");

        return "redirect:/admin/employees";
    }

    @RequestMapping(value = "/admin/employees/{id}", method = RequestMethod.GET)
    public String employeeId(@PathVariable("id") Integer id, Model model) {

        EmployeeForm employeeForm = convertEmployeeToEmployeeForm(employeeServiceDao.findById(id));

        if (employeeForm == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Employee not found");
        }

        model.addAttribute("employeeForm", employeeForm);
        return "admin/employeeShow";
    }


    private void populateDefaultModel(Model model) {
        model.addAttribute("positionList", employeeServiceDao.getAllPositions());

    }

    private Employee convertEmployeeFormToEmployee(EmployeeForm employeeForm) {

        if (employeeForm.getPosition() == Position.Cook) {
            Cook employee = new Cook();
            List<CookedDishes> cookedDishes = new ArrayList<>();
            List<String> cookedDishesIdList = convertDelimitedStringToList(employeeForm.getCookedDishes());

            populateEmployee(employeeForm, employee);
            cookedDishesIdList.forEach(id -> cookedDishes.add(cookedDishesServiceDao.findById(Integer.parseInt(id))));
            employee.setCookedDishes(cookedDishes);

            return employee;

        } else if (employeeForm.getPosition() == Position.Waiter) {
            Waiter employee = new Waiter();
            List<Orders> orders = new ArrayList<>();
            List<String> ordersIdList = convertDelimitedStringToList(employeeForm.getOrders());

            ordersIdList.forEach(id -> orders.add(orderServiceDao.findById(Integer.parseInt(id))));
            populateEmployee(employeeForm, employee);
            employee.setOrders(orders);

            return employee;

        } else {
            Employee employee = new Employee();
            populateEmployee(employeeForm, employee);

            return employee;
        }

    }

    private void populateEmployee(EmployeeForm employeeForm, Employee employee) {
        employee.setId(employeeForm.getId());
        employee.setName(employeeForm.getName());
        employee.setSurname(employeeForm.getSurname());
        employee.setDateOfBirth(employeeForm.getDateOfBirth());
        employee.setPhoneNumber(employeeForm.getPhoneNumber());
        employee.setPosition(employeeForm.getPosition());
        employee.setSalary(employeeForm.getSalary());
    }

    private EmployeeForm convertEmployeeToEmployeeForm(Employee employee) {

        EmployeeForm employeeForm = new EmployeeForm();

        if (employee.getPosition() == Position.Cook) {
            Cook cook = (Cook) employee;
            List<String> cookedDishesIdList = new ArrayList<>();
            List<CookedDishes> cookedDishes = cook.getCookedDishes();

            cookedDishes.forEach(dish -> cookedDishesIdList.add(dish.getId().toString()));
            String cookedDishesString = convertListToDelimitedString(cookedDishesIdList);
            employeeForm.setCookedDishes(cookedDishesString);
            populateEmployeeForm(employeeForm, cook);

            if ("".equals(employeeForm.getCookedDishes())) {
                employeeForm.setCookedDishes("No cooked dishes");
            }

            return employeeForm;

        } else if (employee.getPosition() == Position.Waiter) {
            Waiter waiter = (Waiter) employee;
            List<String> ordersIdList = new ArrayList<>();
            List<Orders> orders = waiter.getOrders();

            orders.forEach(order -> ordersIdList.add(order.getId().toString()));
            String ordersString = convertListToDelimitedString(ordersIdList);

            employeeForm.setOrders(ordersString);
            populateEmployeeForm(employeeForm, waiter);

            if ("".equals(employeeForm.getOrders())) {
                employeeForm.setOrders("No orders");
            }

            return employeeForm;

        } else {
            populateEmployeeForm(employeeForm, employee);

            return employeeForm;
        }

    }

    private void populateEmployeeForm(EmployeeForm employeeForm, Employee employee) {
        employeeForm.setId(employee.getId());
        employeeForm.setName(employee.getName());
        employeeForm.setSurname(employee.getSurname());
        employeeForm.setPhoneNumber(employee.getPhoneNumber());
        employeeForm.setDateOfBirth(employee.getDateOfBirth());
        employeeForm.setPosition(employee.getPosition());
        employeeForm.setSalary(employee.getSalary());

    }

    private static List<String> convertDelimitedStringToList(String delimitedString) {

        List<String> result = new ArrayList<>();

        if ("No orders".equals(delimitedString) || "No cooked dishes".equals(delimitedString)) {
            delimitedString = "";
        }

        if (!StringUtils.isEmpty(delimitedString)) {
            result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ", "));

        }
        return result;

    }

    private String convertListToDelimitedString(List<String> list) {

        String result = "";
        if ( list != null){
            result = StringUtils.arrayToDelimitedString(list.toArray(), ", ");
        }
        return result;

    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest req, EmptyResultDataAccessException ex) {

        logger.debug("handleEmptyData()");
        logger.error("Request: {}, error ", req.getRequestURL(), ex);

        ModelAndView model = new ModelAndView();
        model.setViewName("admin/employeeShow");
        model.addObject("exceptionMsg", ex);
        model.addObject("msg", "Employee is not found");

        return model;

    }

    @Autowired
    public void setOrderServiceDao(OrderServiceDao orderServiceDao) {
        this.orderServiceDao = orderServiceDao;
    }

    @Autowired
    public void setCookedDishesServiceDao(CookedDishesServiceDao cookedDishesServiceDao) {
        this.cookedDishesServiceDao = cookedDishesServiceDao;
    }

    @Autowired
    public void setEmployeeServiceDao(EmployeeServiceDao employeeServiceDao) {
        this.employeeServiceDao = employeeServiceDao;
    }
}
