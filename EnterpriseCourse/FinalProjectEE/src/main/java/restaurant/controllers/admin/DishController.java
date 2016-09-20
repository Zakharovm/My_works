package restaurant.controllers.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import restaurant.formObjects.DishForm;
import restaurant.model.Dish;
import restaurant.model.Ingredient;
import restaurant.service.dao.DishServiceDao;
import restaurant.service.dao.IngredientServiceDao;
import restaurant.validator.DishFormValidator;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.util.*;

@Controller
public class DishController {

    private final Logger logger = LoggerFactory.getLogger(DishController.class);

    private DishServiceDao dishServiceDao;
    private IngredientServiceDao ingredientServiceDao;

    @Autowired
    DishFormValidator dishFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(dishFormValidator);

        binder.registerCustomEditor(Float.class, new CustomNumberEditor(Float.class, false));

        binder.registerCustomEditor(Float.class, "ingredientAmount", new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                Float amount;

                if (text != null) {
                    amount = Float.parseFloat(text);
                } else {
                    amount = 0F;
                }

                setValue(amount);
            }
        });

    }

    @RequestMapping(value = "/admin/dishes", method = RequestMethod.GET)
    public ModelAndView getDishes() {
        ModelAndView modelAndView = new ModelAndView();
        List<Dish> dishList = dishServiceDao.getAllDishes();
        if (dishList == null) {
            throw new EmptyResultDataAccessException(10);
        } else {
            modelAndView.addObject("dishList", dishList);
        }

        modelAndView.setViewName("admin/dishes");
        return modelAndView;
    }

    //saveOrUpdate or update page
    @RequestMapping(value = "/admin/dishes", method = RequestMethod.POST)
    public String saveOrUpdateDish(@ModelAttribute("dishForm") @Validated DishForm dishForm,
                                   BindingResult result, final RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {
            populateDefaultModel(model);
            return "admin/dishForm";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if (dishForm.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "Menu added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "Menu updated successfully!");
            }

            Dish dish;

            dish = convertDishFormToDish(dishForm);

            dishServiceDao.saveOrUpdate(dish);

            return "redirect:/admin/dishes/" + dish.getId();


        }

    }

    // show add user form
    @RequestMapping(value = "/admin/dishes/add", method = RequestMethod.GET)
    public String showAddDishForm(Model model) {
        logger.debug("showAddDishForm()");
        DishForm dishForm = new DishForm();
        List<Float> amountList = new ArrayList<>();
        for (int i = 0; i < ingredientServiceDao.getAllIngredients().size(); i++) {
            amountList.add(0F);
        }

        dishForm.setIngredientAmount(amountList);
        populateDefaultModel(model);

        model.addAttribute("dishForm", dishForm);
        return "admin/dishForm";
    }

    @RequestMapping(value = "/admin/dishes/{id}/update", method = RequestMethod.GET)
    public String showUpdateDishForm(@PathVariable("id") Integer id, Model model) {

        DishForm dishForm = (id == null ? new DishForm() : convertDishToDishForm(dishServiceDao.findById(id)));

        model.addAttribute("dishForm", dishForm);

        populateDefaultModel(model);

        return "admin/dishForm";
    }

    @RequestMapping(value = "/admin/dishes/{id}/delete", method = RequestMethod.POST)
    public String deleteMenu(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {

        logger.debug("deleteDish() : {}", id);

        dishServiceDao.delete(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Menu is deleted!");

        return "redirect:/admin/dishes";
    }

    @RequestMapping(value = "/admin/dishes/{id}", method = RequestMethod.GET)
    public String menuId(@PathVariable("id") Integer id, Model model) {

        DishForm dishForm = convertDishToDishForm(dishServiceDao.findById(id));


        if (dishForm == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Menu not found");
        } else {
            List<Float> amountList = dishForm.getIngredientAmount();
            for (int i = amountList.size(); i > 0; i--) {
                int index = amountList.indexOf(0F);

                if (index != -1) {
                    amountList.remove(index);
                }

            }
            dishForm.setIngredientAmount(amountList);

        }

        model.addAttribute("dishForm", dishForm);
        model.addAttribute("ingredientList", dishServiceDao.findById(id).getComposition().keySet());
        return "admin/dishShow";
    }


    private void populateDefaultModel(Model model) {
        List<Ingredient> ingredientList = ingredientServiceDao.getAllIngredients();
        List<Float> amountList = new ArrayList<>();

        for (int i = 0; i < ingredientList.size(); i++) {
            amountList.add(0F);
        }

        model.addAttribute("ingredientList", ingredientList);
        model.addAttribute("amountList", amountList);
        model.addAttribute("categoryList", dishServiceDao.getAllCategories());
    }

    private Dish convertDishFormToDish(DishForm dishForm) {

        Dish dish = new Dish();
        Map<Ingredient, Float> compositionMap = new HashMap<>();
        Iterator<Ingredient> it1 = ingredientServiceDao.getAllIngredients().iterator();
        Iterator<Float> it2 = dishForm.getIngredientAmount().iterator();

        while (it1.hasNext() && it2.hasNext()) {
            Ingredient key = it1.next();
            Float value = it2.next();
            if (value > 0) {
                compositionMap.put(key, value);
            }

        }

        dish.setId(dishForm.getId());
        dish.setName(dishForm.getName());
        dish.setPrice(dishForm.getPrice());
        dish.setWeight(dishForm.getWeight());
        dish.setCategory(dishForm.getCategory());
        dish.setComposition(compositionMap);

        return dish;
    }

    private DishForm convertDishToDishForm(Dish dish) {

        DishForm dishForm = new DishForm();

        Map<Ingredient, Float> compositionMap = dish.getComposition();
        List<Float> amountList = new ArrayList<>();
        for (int i = 0; i < ingredientServiceDao.getAllIngredients().size(); i++) {
            amountList.add(0F);
        }

        for (Object o : compositionMap.entrySet()) {
            Map.Entry thisEntry = (Map.Entry) o;
            Ingredient ingredient = (Ingredient) thisEntry.getKey();
            Float amount = (Float) thisEntry.getValue();

            amountList.remove(ingredient.getId() - 1);
            amountList.add(ingredient.getId() - 1, amount);

        }

        dishForm.setId(dish.getId());
        dishForm.setName(dish.getName());
        dishForm.setPrice(dish.getPrice());
        dishForm.setWeight(dish.getWeight());
        dishForm.setCategory(dish.getCategory());
        dishForm.setIngredientAmount(amountList);

        return dishForm;
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest req, EmptyResultDataAccessException ex) {

        logger.debug("handleEmptyData()");
        logger.error("Request: {}, error ", req.getRequestURL(), ex);

        ModelAndView model = new ModelAndView();
        model.setViewName("admin/dishShow");
        model.addObject("exceptionMsg", ex);
        model.addObject("msg", "Dish is not found");

        return model;

    }


    @Autowired
    public void setDishServiceDao(DishServiceDao dishServiceDao) {
        this.dishServiceDao = dishServiceDao;
    }

    @Autowired
    public void setIngredientServiceDao(IngredientServiceDao ingredientServiceDao) {
        this.ingredientServiceDao = ingredientServiceDao;
    }
}
