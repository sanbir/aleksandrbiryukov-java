package com.noveogroup.java.biryukov.training.Annotations;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * String Value according to a pattern.
 */
@Target(value = {FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface StringValue {
    String pattern();
}
