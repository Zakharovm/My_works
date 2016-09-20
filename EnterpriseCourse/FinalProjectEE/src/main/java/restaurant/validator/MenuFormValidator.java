package restaurant.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import restaurant.model.Menu;
import restaurant.service.dao.DishServiceDao;
import restaurant.service.dao.MenuServiceDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-mvc-configuring
@Component
public class MenuFormValidator implements Validator {
    private Pattern pattern;
    private Matcher matcher;

    String FLOAT_PATTERN = "^\\d*\\.?\\d*$";
    String STRING_PATTERN = "[a-zA-Z]+";

    @Autowired
    MenuServiceDao menuServiceDao;

    @Autowired
    DishServiceDao dishServiceDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return Menu.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Menu menu = (Menu) target;

        ValidationUtils.rejectIfEmpty(errors, "name", "required.name",
                "Name is required.");

        // input string conatains characters only
        if (!(menu.getName() != null && menu.getName().isEmpty())) {
            pattern = Pattern.compile(STRING_PATTERN);
            matcher = pattern.matcher(menu.getName());
            if (!matcher.matches()) {
                errors.rejectValue("name", "name.containNonString",
                        "Enter a valid name");
            }
        }

        String menuName = menu.getName();

        if (menu.getId() == null) {
            menuServiceDao.getAllMenus().stream().filter(singleMenu -> singleMenu.getName().equals(menuName)).forEach(singleMenu -> {
                errors.rejectValue("name", "name.DuplicateName",
                        "The menu with such name already exists. Choose the another name.");
            });
        }


        if (menu.getDishes() == null || menu.getDishes().size() < 2) {
            errors.rejectValue("dishes", "NotEmpty.menuForm.dishes");
        }


    }

}