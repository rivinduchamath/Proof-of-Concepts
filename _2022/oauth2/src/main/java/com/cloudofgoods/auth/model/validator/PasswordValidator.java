package com.cloudofgoods.auth.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private static final String EMAIL_PATTERN = "12345";
    private Pattern pattern;
    private Matcher matcher;

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(value);
        return matcher.matches();

    }
}
