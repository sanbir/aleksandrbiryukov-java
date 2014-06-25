package com.noveogroup.java.biryukov.training.AnnotationsValidation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Validates NotNull.
 */
public class NotNullValidation implements AnnotationValidation {
    @Override
    public boolean validate(final Object pojo, final Field field, final Annotation annotation) {
        field.setAccessible(true);
        try {
            final Object value = field.get(pojo);
            if (value == null) {
                return false;
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.toString());
        } catch (IllegalAccessException ex) {
            System.err.println(ex.toString());
        }
        return true;
    }
}
