package com.noveogroup.java.biryukov.training.AnnotationsValidation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Validates Nullable.
 */
public class NullableValidation implements AnnotationValidation {
    @Override
    public boolean validate(final Object pojo, final Field field, final Annotation annotation) {
        return true;
    }
}
