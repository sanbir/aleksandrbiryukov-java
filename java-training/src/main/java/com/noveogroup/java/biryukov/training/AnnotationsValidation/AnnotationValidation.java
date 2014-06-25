package com.noveogroup.java.biryukov.training.AnnotationsValidation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Common interface for all the classes validating defined annotations.
 */
public interface AnnotationValidation<E> {
    boolean validate(E pojo, Field field, Annotation annotation);
}
