package restaurant.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import restaurant.service.dao.EmployeeServiceDao;

@Controller
public class StaffController {

    private EmployeeServiceDao employeeServiceDao;

    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees", employeeServiceDao.findAllWaiters());
        modelAndView.setViewName("user/staff");
        return modelAndView;
    }

    @Autowired
    public void setEmployeeService(EmployeeServiceDao employeeServiceDao) {
        this.employeeServiceDao = employeeServiceDao;
    }
}
