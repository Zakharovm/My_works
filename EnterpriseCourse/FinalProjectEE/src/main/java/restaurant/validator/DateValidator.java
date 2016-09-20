package restaurant.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import restaurant.formObjects.DateForm;

@Component
public class DateValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return DateForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DateForm dateForm = (DateForm) target;

        //validate date

            ValidationUtils.rejectIfEmpty(errors, "date", "required.date",
                    "Date is required.");



    }
}
