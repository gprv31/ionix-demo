package com.example.ionix.adapter.input.web.user.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UserNameValidator.class})
public @interface UserNameValid {
  /**
   * message method description.
   *
   * <pre>
   * &lt;module name=&quot;NonEmptyAtclauseDescription&quot;/&gt;
   * </pre>
   */
  String message() default "is invalid";

  /**
   * required field flag.
   *
   * <pre>
   * &lt;module name=&quot;NonEmptyAtclauseDescription&quot;/&gt;
   * </pre>
   */
  boolean required() default false;

  /**
   * groups method description.
   *
   * <pre>
   * &lt;module name=&quot;NonEmptyAtclauseDescription&quot;/&gt;
   * </pre>
   */
  Class<?>[] groups() default {};

  /**
   * payload method description.
   *
   * <pre>
   * &lt;module name=&quot;NonEmptyAtclauseDescription&quot;/&gt;
   * </pre>
   */
  Class<? extends Payload>[] payload() default {};
}
