package com.noveogroup.java.biryukov.training;

import com.noveogroup.java.biryukov.training.AnnotationsValidation.AnnotationValidation;
import com.noveogroup.java.biryukov.training.POJOs.MailMessage;
import com.noveogroup.java.biryukov.training.POJOs.Person;
import com.noveogroup.java.biryukov.training.Buffers.Buffer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Worker is the consumer part of a producer/consumer pattern.
 */
class Worker implements Runnable {

    private Collection<Object> pojosPassedValidation;
    private Collection<Object> pojosFailedValidation;
    private final Buffer buffer;

    public Worker(final Buffer b) {
        buffer = b;
        pojosPassedValidation = new LinkedList<Object>();
        pojosFailedValidation = new LinkedList<Object>();
    }

    public void run() {
        try {
            while (true) { 
                /* repeat over and over again
                   until the end of file is reached */
                final Object pojo = buffer.take();
                if (pojo instanceof Reader.EofMarker) { break; }
                
                final boolean passed = validate(pojo);
                if (passed) {
                    pojosPassedValidation.add(pojo);
                } else {
                    pojosFailedValidation.add(pojo);
                }
            }
            
            /* Console output - report */
            System.out.println("Passed:  " + pojosPassedValidation.size());
            System.out.println("Failed:  " + pojosFailedValidation.size());
            System.out.println(System.lineSeparator() 
                               + "The following POJOs have failed to validate:"
                               + System.lineSeparator());
            for (Object obj : pojosFailedValidation) { printPojo(obj); }
            
        } catch (InterruptedException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * POJO validation through reflection.
     * Returns 'true' if a POJO is valid
     */
    private boolean validate(final Object pojo) {
        AnnotationValidation annotationValidation = null;
        Class<?> clazz = null;
        String className;
        boolean passed;

        for (Field field : pojo.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                className = annotation
                        .annotationType()
                        .getName()
                        .replaceFirst("Annotations", "AnnotationsValidation") + "Validation";
                try {
                    clazz = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    annotationValidation = (AnnotationValidation) clazz.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                passed = annotationValidation.validate(pojo, field, annotation);
                if (!passed) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Print POJO's contents to the standard output stream.
     */
    private void printPojo(final Object pojo) {
        if (pojo instanceof MailMessage) {
            final MailMessage msg = (MailMessage) pojo;
            System.out.println("From: " + msg.getFrom());
            System.out.println("To: " + msg.getTo());

            System.out.print("CC: ");
            for (String str : msg.getCC()) {
                System.out.printf(getFormatValue(), str);
            }
            System.out.println();

            System.out.print("BCC: ");
            for (String str : msg.getBcc()) {
                System.out.printf(getFormatValue(), str);
            }
            System.out.println();

            System.out.println("Date: " + getDateFormat(msg.getDate()));

            System.out.println(getSeparator());
            System.out.println();
        } else if (pojo instanceof Person) {
            final Person msg = (Person) pojo;
            System.out.println("First: " + msg.getFirstName());
            System.out.println("Last: " + msg.getLastName());

            System.out.println("DOB: " + getDateFormat(msg.getBirthDay()));

            System.out.println(getSeparator());
            System.out.println();
        }
    }

    private String getDateFormat(final Date date) {
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }

    private String getFormatValue() {
        return  "%s, ";
    }

    private String getSeparator() {
        return "_______________";
    }
}
