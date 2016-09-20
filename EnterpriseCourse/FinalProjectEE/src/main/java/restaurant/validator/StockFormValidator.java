package restaurant.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import restaurant.model.Stock;
import restaurant.service.dao.IngredientServiceDao;
import restaurant.service.dao.StockServiceDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class StockFormValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;

    @Autowired
    private IngredientServiceDao ingredientServiceDao;

    @Autowired
    private StockServiceDao stockServiceDao;

    private String STRING_PATTERN = "[a-zA-Z]+";
    private String FLOAT_PATTERN = "^\\d*\\.?\\d*$";

    @Override
    public boolean supports(Class<?> aClass) {
        return Stock.class.equals(aClass);
    }


    @Override
    public void validate(Object target, Errors errors) {
        Stock stock = (Stock) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ingredient",
                "ingredient.stockForm", "Enter the amount of ingredient");
        // validate name
        if (!(stock.getIngredient().getName() != null && stock.getIngredient().getName().isEmpty())) {
            pattern = Pattern.compile(STRING_PATTERN);
            matcher = pattern.matcher(stock.getIngredient().getName());
            if (!matcher.matches()) {
                errors.rejectValue("ingredient", "ingredient.stockFrom.containNonChar",
                        "Enter a valid name");
            }
        }
        String ingredientName = stock.getIngredient().getName();

      /*  if (stock.getId() == null && stock.getId() != 0) {
            stockServiceDao.getAllIngredients().stream().filter(ingredient -> ingredient.getIngredient().getName().equals(ingredientName)).forEach(ingredient -> {
                errors.rejectValue("ingredient", "name.DuplicateName",
                        "The ingredient with such name already exists. Choose the another name.");
            });
        } */

        //amount validation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity",
                "quantity.stockForm", "Enter the amount of ingredient");

    }
}
