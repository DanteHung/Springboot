package com.vtxlab.bootcamp.bootcampsbforum.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserIdValidator.class) // how to validate
public @interface UserIdCheck {

  public String message()

  default "Invalid User Id. Please use a valid user id to try again."; // error msg if validation fail

  public Class<?>[] groups() default {};

  public Class<? extends Payload>[] payload() default {};

}
