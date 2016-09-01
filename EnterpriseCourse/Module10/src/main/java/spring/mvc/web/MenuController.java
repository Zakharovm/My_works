package spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.mvc.model.Dish;
import spring.mvc.model.Menu;
import spring.mvc.service.MenuService;

import java.util.List;

@RestController
public class MenuController {
    private MenuService menuService;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public List<Menu> menu() {
        return menuService.getAllMenus();
    }

    @RequestMapping(value = "/menu/{menuName}", method = RequestMethod.GET)
    public Menu menuName(@PathVariable String menuName) {
        return menuService.getMenu(menuName);
    }

    @RequestMapping(value = "/menu/id/{id}", method = RequestMethod.GET)
    public List<Dish> menuId(@PathVariable Integer id) {
        return menuService.getDishesListInMenu(id);
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}
