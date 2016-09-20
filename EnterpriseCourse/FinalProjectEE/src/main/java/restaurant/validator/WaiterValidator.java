package restaurant.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import restaurant.formObjects.HomepageForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class WaiterValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;

    private String STRING_PATTERN = "[a-zA-Z]+";


    @Override
    public boolean supports(Class<?> clazz) {
        return HomepageForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        HomepageForm homepageForm = (HomepageForm) target;
        String waiterName = homepageForm.getInputField();

        //validate waiterName
        ValidationUtils.rejectIfEmpty(errors, "inputField", "required.waiterName",
                "Name is required.");
        if (waiterName != null) {
            // input string contains characters only
            if (!waiterName.isEmpty()) {
                pattern = Pattern.compile(STRING_PATTERN);
                matcher = pattern.matcher(waiterName);
                if (!matcher.matches()) {
                    errors.rejectValue("inputField", "inputField.containNonString",
                            "Enter a valid name");
                }
            }
        }

    }
}
