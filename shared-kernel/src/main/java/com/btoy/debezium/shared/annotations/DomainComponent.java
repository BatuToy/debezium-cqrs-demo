package com.btoy.debezium.shared.annotations;

/*
 * @created 11/10/2025 ~~ 09:46
 * author: batu   
 */

import org.springframework.validation.annotation.Validated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Validated
public @interface DomainComponent {
    String value() default "";
}

