package com.noveogroup.java.biryukov.training.AnnotationsValidation;

import com.noveogroup.java.biryukov.training.Annotations.StringValue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates StringValue.
 */
public class StringValueValidation implements AnnotationValidation {
    @Override
    public boolean validate(final Object pojo, final Field field, final Annotation annotation) {
        final StringValue stringValue = (StringValue) annotation;
        field.setAccessible(true);
        try {
            final String value = (String) field.get(pojo);
            final Pattern p = Pattern.compile(stringValue.pattern(), Pattern.CASE_INSENSITIVE);
            final Matcher m = p.matcher(value);
            if (!m.matches()) {
                return false;
            }
        } catch (ClassCastException ex) {
            try {
                final String[] valueArray = (String[]) field.get(pojo);
                final Pattern p = Pattern.compile(stringValue.pattern(), Pattern.CASE_INSENSITIVE);
                for (String s : valueArray) {
                    final Matcher m = p.matcher(s);
                    if (!m.matches()) {
                        return false;
                    }
                }
            } catch (ClassCastException exc) {
                System.err.println(exc.toString());
            } catch (IllegalArgumentException exc) {
                System.err.println(exc.toString());
            } catch (IllegalAccessException exc) {
                System.err.println(exc.toString());
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.toString());
        } catch (IllegalAccessException ex) {
            System.err.println(ex.toString());
        }
        return true;
    }

}
