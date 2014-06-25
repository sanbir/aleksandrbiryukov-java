package com.noveogroup.java.biryukov.training.AnnotationsValidation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * Validates NotFuture.
 */
public class NotFutureValidation implements AnnotationValidation {
    @Override
    public boolean validate(final Object pojo, final Field field, final Annotation annotation) {
        field.setAccessible(true);
        try {
            final Date value = (Date) (field.get(pojo));
            final Date now = new Date();
            if ((now.getTime() - value.getTime()) < 0) {
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
