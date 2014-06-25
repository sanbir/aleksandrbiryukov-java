package com.noveogroup.java.biryukov.training.AnnotationsValidation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Validates NotBlank.
 */
public class NotBlankValidation implements AnnotationValidation {
    @Override
    public boolean validate(final Object pojo, final Field field, final Annotation annotation) {
        field.setAccessible(true);
        try {
            String value = (String) (field.get(pojo));
            value = value.replaceAll("\\s+", "");
            if ("".equals(value)) {
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
