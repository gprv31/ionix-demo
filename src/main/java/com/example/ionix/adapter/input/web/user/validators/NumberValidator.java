package com.example.ionix.adapter.input.web.user.validators;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator implements ConstraintValidator<NumberValid, String> {

  private boolean required;

  @Override
  public void initialize(NumberValid numberValid) {
    this.required = numberValid.required();
  }

  @Override
  public boolean isValid(String number, ConstraintValidatorContext context) {
    if (!required && StringUtils.isBlank(number)) {
      return true;
    }
    Pattern p = Pattern.compile("^[0-9]\\d*$");
    Matcher m = p.matcher(number.trim());
    if (!m.matches()) {
      return false;
    }
    return Long.parseLong(number) > 0;
  }
}
