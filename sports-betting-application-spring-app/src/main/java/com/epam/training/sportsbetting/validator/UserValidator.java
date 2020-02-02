package com.epam.training.sportsbetting.validator;

import com.epam.training.sportsbetting.domain.dto.PlayerRegisterDto;
import com.epam.training.sportsbetting.domain.user.User;
import com.epam.training.sportsbetting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    private static final Pattern EMAIL_REGEX =
            Pattern.compile("^[\\w\\d._-]+@[\\w\\d.-]+\\.[\\w\\d]{2,6}$");

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PlayerRegisterDto user = (PlayerRegisterDto) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (user.getEmail().length() < 2 || user.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.userForm.username");
        }
        if (user.getEmail() != null && !EMAIL_REGEX.matcher(user.getEmail()).matches()) {
            errors.rejectValue("email", "Username.email.invalid");
        }
        if (userService.findByUsername(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 2 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }

}
