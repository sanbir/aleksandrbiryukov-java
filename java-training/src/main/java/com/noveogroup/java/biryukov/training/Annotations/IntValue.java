package com.noveogroup.java.biryukov.training.Annotations;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Int from min to max.
 */
@Target(value = {FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface IntValue {
    int min();
    int max();
}
