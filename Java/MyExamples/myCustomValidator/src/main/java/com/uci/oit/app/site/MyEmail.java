package com.uci.oit.app.site;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={})
@Pattern(regexp="^[a-z0-9`!#$%^&*'{}?/+=|_~-]+(\\.[a-z0-9`!#$%^&*'{}?/+=|" +
                "_~-]+)*@([a-z0-9]([a-z0-9-]*[a-z0-9])?)+(\\.[a-z0-9]" +
                "([a-z0-9-]*[a-z0-9])?)*$", flags={Pattern.Flag.CASE_INSENSITIVE})
@ReportAsSingleViolation
public @interface MyEmail
{
    String message() default "Email must be valid!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
    ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    static @interface List {
    MyEmail[] value();
    }

}
