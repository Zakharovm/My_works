package spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.mvc.model.Position;
import spring.mvc.service.EmployeeService;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees", employeeService.getAllWaiters(Position.Waiter));
        modelAndView.setViewName("staff");
        return modelAndView;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
