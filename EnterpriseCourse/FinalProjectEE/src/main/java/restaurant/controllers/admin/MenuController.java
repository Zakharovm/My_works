package restaurant.controllers.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import restaurant.model.Dish;
import restaurant.model.Menu;
import restaurant.service.dao.DishServiceDao;
import restaurant.service.dao.MenuServiceDao;
import restaurant.validator.MenuFormValidator;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {
    private final Logger logger = LoggerFactory.getLogger(MenuController.class);


    private MenuServiceDao menuServiceDao;
    private DishServiceDao dishServiceDao;

    @Autowired
    MenuFormValidator menuFormValidator;


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Dish.class, "dishes", new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                Dish dish = createDishFromName(text);
                setValue(dish);
            }

        });


        binder.setValidator(menuFormValidator);
    }

    private Dish createDishFromName(String dishName) {
        return dishServiceDao.findByName(dishName);
    }

    @RequestMapping(value = {"/admin", "/admin/menus"}, method = RequestMethod.GET)
    public ModelAndView menu() {
        ModelAndView modelAndView = new ModelAndView();
    List<Menu> menuList = menuServiceDao.getAllMenus();
    if (menuList == null) {
        throw new EmptyResultDataAccessException(10);
    } else {
        modelAndView.addObject("menuList", menuList);
    }

    modelAndView.setViewName("admin/menu");
    return modelAndView;
}

    //saveOrUpdate or update
    @RequestMapping(value = "/admin/menus", method = RequestMethod.POST)
    public String saveOrUpdateMenu(@ModelAttribute("menuForm") @Validated Menu menu,
                                   BindingResult result, final RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {
            populateDefaultModel(model);
            return "admin/menuForm";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if (menu.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "Menu added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "Menu updated successfully!");
            }

            menuServiceDao.saveOrUpdate(menu);

            return "redirect:/admin/menus/" + menu.getId();


        }

    }

    // show add user form
    @RequestMapping(value = "/admin/menus/add", method = RequestMethod.GET)
    public String showAddMenuForm(Model model) {
        logger.debug("showAddMenuForm()");
        Menu menu = new Menu();
        List<Dish> dishes = new ArrayList<>();
        dishes.add(dishServiceDao.findById(10));
        dishes.add(dishServiceDao.findById(1));
        dishes.add(dishServiceDao.findById(8));
        dishes.add(dishServiceDao.findById(2));

        menu.setDishes(dishes);
        populateDefaultModel(model);

        model.addAttribute("menuForm", menu);
        return "admin/menuForm";
    }

    @RequestMapping(value = "/admin/menus/{id}/update", method = RequestMethod.GET)
    public String showUpdateMenuForm(@PathVariable("id") Integer id, Model model) {

        Menu menu = (id == null ? new Menu() : menuServiceDao.findById(id));

        model.addAttribute("menuForm", menu);

        populateDefaultModel(model);

        return "admin/menuForm";
    }

    @RequestMapping(value = "/admin/menus/{id}/delete", method = RequestMethod.POST)
    public String deleteMenu(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {

        logger.debug("deleteMenu() : {}", id);

        menuServiceDao.delete(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Menu is deleted!");

        return "redirect:/admin/menus";
    }

    @RequestMapping(value = "/admin/menus/{id}", method = RequestMethod.GET)
    public String menuId(@PathVariable("id") Integer id, Model model) {

        Menu menu = menuServiceDao.findById(id);

        if (menu == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Menu not found");
        }
        model.addAttribute("menu", menu);
        return "admin/menuShow";
    }


    private void populateDefaultModel(Model model) {

        model.addAttribute("dishList", dishServiceDao.getAllDishes());

    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest req, EmptyResultDataAccessException ex) {

        logger.debug("handleEmptyData()");
        logger.error("Request: {}, error ", req.getRequestURL(), ex);

        ModelAndView model = new ModelAndView();
        model.setViewName("admin/menuShow");
        model.addObject("exceptionMsg", ex);
        model.addObject("msg", "Menu is not found");

        return model;

    }

    @Autowired
    public void setMenuServiceDao(MenuServiceDao menuServiceDao) {
        this.menuServiceDao = menuServiceDao;
    }

    @Autowired
    public void setDishServiceDao(DishServiceDao dishServiceDao) {
        this.dishServiceDao = dishServiceDao;
    }
}
