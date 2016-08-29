package spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.mvc.service.MenuService;

@Controller
public class MenuController {
    private MenuService menuService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("menu", menuService.getAllDishesInMenu("Spring_morning"));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/{dish}", method = RequestMethod.GET)
    public ModelAndView dishName(@PathVariable String dish) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dish", menuService.getDish(dish));
        modelAndView.setViewName("dish");

        return modelAndView;
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}
