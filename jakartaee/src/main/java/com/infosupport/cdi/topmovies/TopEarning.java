package com.infosupport.cdi.topmovies;

import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
@Target({TYPE, PARAMETER, FIELD, METHOD, CONSTRUCTOR})
public @interface TopEarning {
}
