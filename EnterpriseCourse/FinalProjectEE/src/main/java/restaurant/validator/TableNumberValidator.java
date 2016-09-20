package restaurant.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import restaurant.formObjects.TableNumberForm;

@Component
public class TableNumberValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return TableNumberForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        //table number validation
        ValidationUtils.rejectIfEmpty(errors, "tableNumber", "required.tableNumber",
                "Number is required.");

    }
}


