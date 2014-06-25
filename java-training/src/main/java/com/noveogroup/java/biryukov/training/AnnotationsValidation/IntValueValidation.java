package com.noveogroup.java.biryukov.training.AnnotationsValidation;

import com.noveogroup.java.biryukov.training.Annotations.IntValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Validates IntValue.
 */
public class IntValueValidation implements AnnotationValidation {

    @Override
    public boolean validate(final Object pojo, final Field field, final Annotation annotation) {
        final IntValue intValue = (IntValue) annotation;
        field.setAccessible(true);
        try {
            final int value = (Integer) (field.get(pojo));
            if (value > intValue.max() || value < intValue.min()) {
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
