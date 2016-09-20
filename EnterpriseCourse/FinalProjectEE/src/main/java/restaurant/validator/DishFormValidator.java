package restaurant.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import restaurant.formObjects.DishForm;
import restaurant.service.dao.DishServiceDao;
import restaurant.service.dao.IngredientServiceDao;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DishFormValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;

    String FLOAT_PATTERN = "^\\d*\\.?\\d*$";
    String STRING_PATTERN = "[a-zA-Z]+";

    @Autowired
    private DishServiceDao dishServiceDao;

    @Autowired
    private IngredientServiceDao ingredientServiceDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return DishForm.class.equals(aClass);
    }


    @Override
    public void validate(Object target, Errors errors) {

        DishForm dishForm = (DishForm) target;

        ValidationUtils.rejectIfEmpty(errors, "name", "required.name",
                "Name is required.");

        // input string conatains characters only
        if (!(dishForm.getName() != null && dishForm.getName().isEmpty())) {
            pattern = Pattern.compile(STRING_PATTERN);
            matcher = pattern.matcher(dishForm.getName());
            if (!matcher.matches()) {
                errors.rejectValue("name", "name.containNonChar",
                        "Enter a valid name");
            }
        }

        String dishName = dishForm.getName();

        if (dishForm.getId() == null) {
            dishServiceDao.getAllDishes().stream().filter(dish -> dish.getName().equals(dishName)).forEach(dish -> {
                errors.rejectValue("name", "name.DuplicateName",
                        "The dish with such name already exists. Choose the another name.");
            });
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "NotEmpty.dishForm.category");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weight", "NotEmpty.dishForm.weight");

        if (dishForm.getPrice() != null) {
            pattern = Pattern.compile(FLOAT_PATTERN);
            matcher = pattern.matcher(dishForm.getPrice().toString());
            if (!matcher.matches()) {
                errors.rejectValue("price",
                        "OnlyNumeric.dishForm.price");
            }
        }

        if (dishForm.getWeight() != null) {
            pattern = Pattern.compile(FLOAT_PATTERN);
            matcher = pattern.matcher(dishForm.getWeight().toString());
            if (!matcher.matches()) {
                errors.rejectValue("weight",
                        "OnlyNumeric.dishForm.weight");
            }
        }

        List<Float> composition = dishForm.getIngredientAmount();

        if (composition == null || dishForm.getIngredientAmount().size() < 1) {
            errors.rejectValue("ingredientAmount", "NotEmpty.dishForm.ingredientAmount");
        }

        Integer counter = 0;
        if (composition != null) {
            for (Float value : composition) {
                if (value != null) {
                    pattern = Pattern.compile(FLOAT_PATTERN);
                    matcher = pattern.matcher(value.toString());
                    if (!matcher.matches()) {
                        errors.rejectValue("ingredientAmount",
                                "OnlyNumeric.dishForm.ingredientAmount");
                    }

                    if (value != 0) {
                        counter++;
                    }
                }
            }
        }

        if (counter < 1) {
            errors.rejectValue("ingredientAmount", "NotEmpty.dishForm.ingredientAmount");
        }

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