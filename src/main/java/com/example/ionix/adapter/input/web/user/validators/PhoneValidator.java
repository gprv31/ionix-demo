package com.example.ionix.adapter.input.web.user.validators;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<PhoneValid, String> {

  private boolean required;

  @Override
  public void initialize(PhoneValid phoneValid) {
    this.required = phoneValid.required();
  }

  @Override
  public boolean isValid(String phone, ConstraintValidatorContext context) {
    if (!required && StringUtils.isBlank(phone)) {
      return true;
    }
    Pattern p = Pattern.compile("^[0-9]*$");
    Matcher m = p.matcher(phone.trim());
    return m.matches();
  }
}
