package com.example.ionix.adapter.input.web.user.validators;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<NameValid, String> {

  private boolean required;

  @Override
  public void initialize(NameValid nameValid) {
    this.required = nameValid.required();
  }

  @Override
  public boolean isValid(String name, ConstraintValidatorContext context) {
    if (!required && StringUtils.isBlank(name)) {
      return true;
    }
    Pattern p = Pattern.compile("^[a-zA-Z ]*$");
    Matcher m = p.matcher(name.trim());
    return m.matches();
  }
}
