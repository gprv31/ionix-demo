package com.example.ionix.adapter.input.web.user.validators;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserNameValidator implements ConstraintValidator<UserNameValid, String> {
  private boolean required;

  @Override
  public void initialize(UserNameValid userNameValid) {
    this.required = userNameValid.required();
  }

  @Override
  public boolean isValid(String userName, ConstraintValidatorContext context) {
    if (!required && StringUtils.isBlank(userName)) {
      return true;
    }
    Pattern p = Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$");
    Matcher m = p.matcher(userName.trim());
    return m.matches();
  }
}
