package restaurant.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import restaurant.formObjects.HomepageForm;
import restaurant.model.Dish;
import restaurant.service.dao.DishServiceDao;
import restaurant.service.dao.MenuServiceDao;

@Controller
public class HomepageController {
    public static final int MenuID = 1;

    private MenuServiceDao menuServiceDao;
    private DishServiceDao dishServiceDao;

    @RequestMapping(value = {"/", "/homepage"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("menuList", menuServiceDao.getAllMenus());
        modelAndView.addObject("categories", menuServiceDao.getAllCategories(MenuID));
        modelAndView.addObject("homePageForm", new HomepageForm());
        modelAndView.setViewName("user/homepage");
        return modelAndView;
    }

    @RequestMapping(value = "/homepage/{dish}", method = RequestMethod.GET)
    public ModelAndView dishName(@PathVariable String dish) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dish", menuServiceDao.getDish(dish));
        modelAndView.setViewName("user/dish");

        return modelAndView;
    }

    @RequestMapping(value = "/homepage/search/dish", method = RequestMethod.POST)
    public String searchDish(@ModelAttribute("homePageForm") HomepageForm homePageForm, final RedirectAttributes redirectAttributes, Model model) {
        String dishName = homePageForm.getInputField();

        for (Dish dish : dishServiceDao.getAllDishes()
                ) {
            if (dish.getName().equalsIgnoreCase(dishName)) {
                dishName = dish.getName();
                dishServiceDao.findByName(dishName);
            }

        }

        if (dishServiceDao.findByName(dishName) != null) {
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "Result of the search is successful!");
            return "redirect:/homepage/" + dishName;
        } else {
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("msg", "The dish is not found!");
            redirectAttributes.addFlashAttribute("menuList", menuServiceDao.getAllMenus());
            redirectAttributes.addFlashAttribute("categories", menuServiceDao.getAllCategories(MenuID));
            return "redirect:/homepage";
        }

    }

    @Autowired
    public void setMenuService(MenuServiceDao menuServiceDao) {
        this.menuServiceDao = menuServiceDao;
    }

    @Autowired
    public void setDishServiceDao(DishServiceDao dishServiceDao) {
        this.dishServiceDao = dishServiceDao;
    }
}
