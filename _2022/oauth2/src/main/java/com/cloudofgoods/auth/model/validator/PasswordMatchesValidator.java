package com.cloudofgoods.auth.model.validator;//package com.cloudofgoods.auth.model.validator;
//
//import com.cloudofgoods.auth.dto.UserRegisterDTO;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
//
//    @Override
//    public void initialize(PasswordMatches constraintAnnotation) {
//    }
//
//    @Override
//    public boolean isValid(Object obj, ConstraintValidatorContext context) {
//        UserRegisterDTO user = (UserRegisterDTO) obj;
//        return user.getPassword().equals(user.getMatchingPassword());
//    }
//}
