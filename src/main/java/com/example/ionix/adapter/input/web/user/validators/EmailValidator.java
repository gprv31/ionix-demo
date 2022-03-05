package com.example.ionix.adapter.input.web.user.validators;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<EmailValid, String> {

  private boolean required;

  @Override
  public void initialize(EmailValid emailValid) {
    this.required = emailValid.required();
  }

  @Override
  public boolean isValid(String email, ConstraintValidatorContext context) {
    if (!required && StringUtils.isBlank(email)) {
      return true;
    }
    Pattern p = Pattern.compile("^(.+)@(.+)$");
    Matcher m = p.matcher(email.trim());
    return m.matches();
  }
}
