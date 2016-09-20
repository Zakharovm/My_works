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
import restaurant.formObjects.HomepageForm;
import restaurant.model.Ingredient;
import restaurant.model.Stock;
import restaurant.service.dao.IngredientServiceDao;
import restaurant.service.dao.StockServiceDao;
import restaurant.validator.StockFormValidator;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StockController {

    private final Logger logger = LoggerFactory.getLogger(StockController.class);


    private StockServiceDao stockServiceDao;
    private IngredientServiceDao ingredientServiceDao;

    @Autowired
    StockFormValidator stockFormValidator;


    @InitBinder("stockForm")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(stockFormValidator);
        binder.registerCustomEditor(Float.class, new CustomNumberEditor(Float.class, false));
        binder.registerCustomEditor(Ingredient.class, "ingredient", new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {

                Ingredient ingredient;
                if (ingredientServiceDao.findByName(text) == null) {
                    ingredient = new Ingredient();
                    ingredient.setName(text);
                    setValue(ingredient);
                } else {
                    setValue(ingredientServiceDao.findByName(text));
                }

            }

        });
    }

    @RequestMapping(value = "/admin/stock", method = RequestMethod.GET)
    public ModelAndView getIngredients() {
        ModelAndView modelAndView = new ModelAndView();
        List<Stock> ingredients = stockServiceDao.getAllIngredients();
        if (ingredients == null) {
            throw new EmptyResultDataAccessException(10);
        } else {
            modelAndView.addObject("ingredientList", ingredients);
        }
        Stock stock = new Stock();
        modelAndView.addObject("stockForm", stock);
        modelAndView.addObject("homePageForm", new HomepageForm());
        modelAndView.setViewName("admin/stock");
        return modelAndView;
    }

    //saveOrUpdate or update
    @RequestMapping(value = "/admin/stock", method = RequestMethod.POST)
    public String saveOrUpdateEmployee(@ModelAttribute("stockForm") @Validated Stock stock,
                                       BindingResult result, final RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {
            logger.info("error stock");
            populateDefaultModel(model);
            return "admin/stockForm";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if (stock.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "Stock added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "Stock updated successfully!");
            }

            List<String> ingredientNames = new ArrayList<>();

            ingredientServiceDao.getAllIngredients().forEach(ingredient -> ingredientNames.add(ingredient.getName()));
            if (!ingredientNames.contains(stock.getIngredient().getName())) {
                ingredientServiceDao.saveOrUpdate(stock.getIngredient());
            }

            stockServiceDao.saveOrUpdate(stock);

            return "redirect:/admin/stock/" + stock.getId();


        }

    }

    // show add user form
    @RequestMapping(value = "/admin/stock/add", method = RequestMethod.GET)
    public String showAddStockForm(Model model) {
        logger.debug("showAddStockForm()");
        Stock stock = new Stock();

        populateDefaultModel(model);

        model.addAttribute("stockForm", stock);
        return "admin/stockForm";
    }

    @RequestMapping(value = "/admin/stock/{id}/update", method = RequestMethod.GET)
    public String showUpdateStockForm(@PathVariable("id") Integer id, Model model) {

        Stock stock = (id == null ? new Stock() : stockServiceDao.findById(id));

        model.addAttribute("stockForm", stock);

        logger.info("stock update ingredient " + stock.getIngredient());

        populateDefaultModel(model);

        return "admin/stockForm";
    }

    @RequestMapping(value = "/admin/stock/{id}/delete", method = RequestMethod.POST)
    public String deleteEmployee(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {

        logger.debug("deleteStockElement() : {}", id);

        stockServiceDao.delete(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Stock ingredient is deleted!");

        return "redirect:/admin/stock";
    }

    @RequestMapping(value = "/admin/stock/{id}", method = RequestMethod.GET)
    public String stockId(@PathVariable("id") Integer id, Model model) {

        Stock stock = stockServiceDao.findById(id);

        if (stock == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Stock element is not found");
        }
        model.addAttribute("stock", stock);
        return "admin/stockShow";
    }

    private void populateDefaultModel(Model model) {

        model.addAttribute("ingredientList", ingredientServiceDao.getAllIngredients());
    }

    @ModelAttribute("homePageForm")
    public HomepageForm getHomePageObject() {
        return new HomepageForm();
    }

    @RequestMapping(value = "/admin/stock/filter", method = RequestMethod.POST)
    public String filterIngredient(@ModelAttribute("homePageForm") HomepageForm homePageForm, final RedirectAttributes redirectAttributes, Model model) {
        String ingredientName = homePageForm.getInputField();


        for (Ingredient ingredient : ingredientServiceDao.getAllIngredients()
                ) {
            if (ingredient.getName().equalsIgnoreCase(ingredientName)) {
                ingredientName = ingredient.getName();
                ingredientServiceDao.findByName(ingredientName);
            }

        }

        if (ingredientServiceDao.findByName(ingredientName) != null) {
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "Result of the search is successful!");
            redirectAttributes.addFlashAttribute("stockIngredient", stockServiceDao.findByIngredientName(ingredientName));
            redirectAttributes.addFlashAttribute("filter", ingredientName);
            return "redirect:/admin/stock";
        } else {
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("msg", "The ingredient is not found!");
            return "redirect:/admin/stock";
        }


    }


    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest req, EmptyResultDataAccessException ex) {

        logger.debug("handleEmptyData()");
        logger.error("Request: {}, error ", req.getRequestURL(), ex);

        ModelAndView model = new ModelAndView();
        model.setViewName("admin/stockShow");
        model.addObject("exceptionMsg", ex);
        model.addObject("msg", "Stock ingredient is not found");

        return model;

    }

    @Autowired
    public void setStockServiceDao(StockServiceDao stockServiceDao) {
        this.stockServiceDao = stockServiceDao;
    }

    @Autowired
    public void setIngredientServiceDao(IngredientServiceDao ingredientServiceDao) {
        this.ingredientServiceDao = ingredientServiceDao;
    }
}


