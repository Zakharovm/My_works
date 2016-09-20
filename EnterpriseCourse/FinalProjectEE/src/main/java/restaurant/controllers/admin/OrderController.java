package restaurant.controllers.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import restaurant.exceptions.ClosedOrderException;
import restaurant.formObjects.DateForm;
import restaurant.formObjects.HomepageForm;
import restaurant.formObjects.TableNumberForm;
import restaurant.model.Waiter;
import restaurant.service.dao.EmployeeServiceDao;
import restaurant.service.dao.OrderServiceDao;
import restaurant.validator.DateValidator;
import restaurant.validator.TableNumberValidator;
import restaurant.validator.WaiterValidator;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private OrderServiceDao orderServiceDao;
    private EmployeeServiceDao employeeServiceDao;

    @Autowired
    private DateValidator dateValidator;

    @Autowired
    private WaiterValidator waiterValidator;

    @Autowired
    private TableNumberValidator tableNumberValidator;

    @InitBinder("dateForm")
    private void DateBinder(WebDataBinder binder) {
        binder.setValidator(dateValidator);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(dateFormat, true));
    }

    @InitBinder("waiterForm")
    private void WaiterBinder(WebDataBinder binder) {
        binder.setValidator(waiterValidator);
    }

    @InitBinder("tableNumberForm")
    private void TableBinder(WebDataBinder binder) {
        binder.setValidator(tableNumberValidator);
    }

    @InitBinder
    private void InitBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), false);
        binder.registerCustomEditor(Date.class, editor);

        binder.registerCustomEditor(Waiter.class, "waiter", new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                Waiter waiter = createWaiterFromName(text);
                setValue(waiter);
            }

        });

    }

    private Waiter createWaiterFromName(String text) {
        return employeeServiceDao.findWaiterByName(text);
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "/admin/orders", method = RequestMethod.GET)
    public String getAllOrders(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("orders", orderServiceDao.getAllOrders());
        return "admin/orders";
    }

    @RequestMapping(value = "/admin/orders/filter", method = RequestMethod.GET)
    public String filterPage(Model model) {

        model.addAttribute("dateForm", new DateForm());
        model.addAttribute("waiterForm", new HomepageForm());
        model.addAttribute("tableNumberForm", new TableNumberForm());

        return "admin/filters";
    }

    @RequestMapping(value = "/admin/orders/filter/date", method = RequestMethod.POST)
    public String filterByDate(@ModelAttribute("dateForm") @Validated DateForm dateForm, BindingResult result,
                               final RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {
            logger.info(" result has error" + result.getAllErrors());
            model.addAttribute("dateForm", new DateForm());
            model.addAttribute("waiterForm", new HomepageForm());
            model.addAttribute("tableNumberForm", new TableNumberForm());
            return "admin/filters";

        } else {
            Date date1 = dateForm.getDate();

            if (orderServiceDao.dateFilter(date1) != null) {
                redirectAttributes.addFlashAttribute("css", "success");
                redirectAttributes.addFlashAttribute("msg", "Result of the search is successful!");
                redirectAttributes.addFlashAttribute("filter", orderServiceDao.dateFilter(date1));
                redirectAttributes.addFlashAttribute("filterValue", dateFormat.format(date1));
                redirectAttributes.addFlashAttribute("filterName", "Date filter ");
                return "redirect:/admin/orders";
            } else {
                redirectAttributes.addFlashAttribute("css", "danger");
                redirectAttributes.addFlashAttribute("msg", "No order with such date!");
                return "redirect:/admin/orders";
            }
        }




    }

    @RequestMapping(value = "/admin/orders/filter/waiterName", method = RequestMethod.POST)
    public String filterByName(@ModelAttribute("waiterForm") @Validated HomepageForm waiterForm,
                               BindingResult result, final RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("dateForm", new DateForm());
            model.addAttribute("waiterForm", new HomepageForm());
            model.addAttribute("tableNumberForm", new TableNumberForm());
            return "admin/filters";
        } else {
            String waiterName = waiterForm.getInputField();
            if (employeeServiceDao.findWaiterByName(waiterName) != null) {
                if (orderServiceDao.waiterFilter(waiterName) != null || orderServiceDao.waiterFilter(waiterName).size() != 0) {
                    logger.info("found waiter " + orderServiceDao.waiterFilter(waiterName));
                    redirectAttributes.addFlashAttribute("css", "success");
                    redirectAttributes.addFlashAttribute("msg", "Such orders found!");
                    redirectAttributes.addFlashAttribute("filterName", "Waiter name filter ");
                    redirectAttributes.addFlashAttribute("filterValue", waiterName);
                    redirectAttributes.addFlashAttribute("filter", orderServiceDao.waiterFilter(waiterName));
                } else {
                    redirectAttributes.addFlashAttribute("css", "danger");
                    redirectAttributes.addFlashAttribute("msg", "No orders with such waiter!");
                }

                return "redirect:/admin/orders";
            } else {
                redirectAttributes.addFlashAttribute("css", "danger");
                redirectAttributes.addFlashAttribute("msg", "No orders with such waiter!");
                return "redirect:/admin/orders";
            }




        }
    }

    @RequestMapping(value = "/admin/orders/filter/tableNumber", method = RequestMethod.POST)
    public String filterByNumber(@ModelAttribute("tableNumberForm") @Validated TableNumberForm tableNumberForm,
                                 BindingResult result, final RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("dateForm", new DateForm());
            model.addAttribute("waiterForm", new HomepageForm());
            model.addAttribute("tableNumberForm", new TableNumberForm());
            return "admin/filters";
        } else {

            Integer number = tableNumberForm.getTableNumber();
            logger.info("table number size " + orderServiceDao.tableFilter(number));

            if (orderServiceDao.tableFilter(number) != null || orderServiceDao.tableFilter(number).size() != 0) {
                redirectAttributes.addFlashAttribute("css", "success");
                redirectAttributes.addFlashAttribute("msg", "Such orders found!");
                redirectAttributes.addFlashAttribute("filterName", "Table number filter ");
                redirectAttributes.addFlashAttribute("filterValue", number);
                redirectAttributes.addFlashAttribute("filter", orderServiceDao.tableFilter(number));
            } else {
                redirectAttributes.addFlashAttribute("css", "danger");
                redirectAttributes.addFlashAttribute("msg", "No orders with such date!");
            }

            return "redirect:/admin/orders";
        }
    }


    @ExceptionHandler(ClosedOrderException.class)
    public ModelAndView handleClosedOrderException(HttpServletRequest req, ClosedOrderException ex) {

        logger.debug("handleEmptyData()");
        logger.error("Request: {}, error ", req.getRequestURL(), ex);

        ModelAndView model = new ModelAndView();
        model.setViewName("error/exception");
        model.addObject("exceptionMsg", ex);
        model.addObject("msg", "[Error]: Closed order is found. " + ex.getOrderId() + " You cannot saveOrUpdate the dish to the closed order.");

        return model;

    }


    @Autowired
    public void setOrderServiceDao(OrderServiceDao orderServiceDao) {
        this.orderServiceDao = orderServiceDao;
    }

    @Autowired
    public void setEmployeeServiceDao(EmployeeServiceDao employeeServiceDao) {
        this.employeeServiceDao = employeeServiceDao;
    }
}
