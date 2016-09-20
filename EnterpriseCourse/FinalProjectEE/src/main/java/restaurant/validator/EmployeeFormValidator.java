package restaurant.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import restaurant.formObjects.EmployeeForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmployeeFormValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;

    String MOBILE_PATTERN = "[0-9]{10}";
    String ID_PATTERN = "[0-9]+";
    String FLOAT_PATTERN = "^\\d*\\.?\\d*$";
    String STRING_PATTERN = "[a-zA-Z]+";


    @Override
    public boolean supports(Class<?> aClass) {
        return EmployeeForm.class.equals(aClass);
    }


    @Override
    public void validate(Object target, Errors errors) {
        EmployeeForm employeeForm = (EmployeeForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber",
                "required.phone", "Phone is required.");

// phone number validation
        if (!(employeeForm.getPhoneNumber() != null && employeeForm.getPhoneNumber().isEmpty())) {
            String phoneNo = employeeForm.getPhoneNumber();
            //validate phone numbers of format "1234567890"
            if (phoneNo.matches("\\d{10}")) {
            }
            //validating phone number with -, . or spaces
            else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {

            }
            //vvalidating phone number with -, . or spaces
            else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{2}[-\\.\\s]\\d{2}")) {

            }
            //validating phone number with extension length from 3 to 5
            else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {

            }
            //validating phone number where area code is in braces ()
            else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {

            }
            //return false if nothing matches the input
            else errors.rejectValue("phoneNumber", "phone.incorrect",
                        "Enter a correct phone number");

        }


        // validate name
        if (!(employeeForm.getName() != null && employeeForm.getName().isEmpty())) {
            pattern = Pattern.compile(STRING_PATTERN);
            matcher = pattern.matcher(employeeForm.getName());
            if (!matcher.matches()) {
                errors.rejectValue("name", "name.employeeForm.containNonChar",
                        "Enter a valid name");
            }
        }

        // validate surname
        if (!(employeeForm.getSurname() != null && employeeForm.getSurname().isEmpty())) {
            pattern = Pattern.compile(STRING_PATTERN);
            matcher = pattern.matcher(employeeForm.getSurname());
            if (!matcher.matches()) {
                errors.rejectValue("surname", "surname.containNonChar",
                        "Enter a valid surname");
            }
        }


        // date of birth validation
        if (!(employeeForm.getDateOfBirth() != null && employeeForm.getDateOfBirth().isEmpty())) {
            String dateOfBirth = employeeForm.getDateOfBirth();
            //validate phone numbers of format "1234567890"
            if (dateOfBirth.matches("\\d{8}")) {
            }
            //validating dateOfBirth with -, . or spaces
            else if (dateOfBirth.matches("\\d{2}[-\\.\\s]\\d{2}[-\\.\\s]\\d{4}")) {

            }
            //return false if nothing matches the input
            else errors.rejectValue("dateOfBirth", "dateOfBirth.incorrect",
                        "Enter a correct date of birth");

        }


        //radio buttons validation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position",
                "required.position", "Select your position");

        //salary validation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary",
                "required.salary", "Enter the salary amount");
        if (employeeForm.getSalary() != null ) {
            pattern = Pattern.compile(FLOAT_PATTERN);
            matcher = pattern.matcher(employeeForm.getSalary().toString());
            if (!matcher.matches()) {
                errors.rejectValue("salary",
                        "required.salary", "Enter the salary amount");
            }
        }

    }
}
