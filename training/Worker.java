package training;

import training.Annotations.*;
import training.Buffers.Buffer;
import training.POJOs.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

/**
 *
 * Worker is the consumer part of a producer/consumer pattern
 */
public class Worker implements Runnable {
    
    private Collection<Object> pojosPassedValidation;
    private Collection<Object> pojosFailedValidation;
    private final Buffer buffer;

    public Worker(Buffer b) {
        buffer = b;
        pojosPassedValidation = new LinkedList<>();
        pojosFailedValidation = new LinkedList<>();
    }
    
    @Override
    public void run() {
        try {
            while (true) { 
                /* repeat over and over again
                   until the end of file is reached */
                Object pojo = buffer.take();
                if (pojo instanceof Reader.EofMarker) break;
                
                boolean passed = validate(pojo);
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
                               + System.lineSeparator() );
            for(Object obj : pojosFailedValidation) printPojo(obj);
            
        } catch (InterruptedException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * POJO validation through reflection
     * Returns 'true' if a POJO is valid
     */
    private boolean validate(Object pojo) {    
        /* for each POJO field*/
       for(Field field : pojo.getClass().getDeclaredFields()){  
           /* for each annotation of a field */
           for(Annotation annotation : field.getDeclaredAnnotations()){
               /* check all annotations defined in training.Annotations */
               if(annotation instanceof Nullable){
                   /* gain access to private fields */
                   field.setAccessible(true);
                   try {
                       Object value = field.get(pojo);
                       if(value == null)
                           break;
                   } catch (IllegalArgumentException | IllegalAccessException ex) {
                       System.err.println(ex.toString());
                   }
               } if(annotation instanceof IntValue){
                   IntValue intValue = (IntValue) annotation;
                   field.setAccessible(true);
                   try {
                       int value = (int)(field.get(pojo));
                       if(value > intValue.max() || value < intValue.min()) 
                           return false;
                   } catch (IllegalArgumentException | IllegalAccessException ex) {
                       System.err.println(ex.toString());
                   }
               } if(annotation instanceof NotBlank){
                   field.setAccessible(true);
                   try {
                       String value = (String)(field.get(pojo));
                       value = value.replaceAll("\\s+","");
                       if("".equals(value))
                           return false;
                   } catch (IllegalArgumentException | IllegalAccessException ex) {
                       System.err.println(ex.toString());
                   }
               } if(annotation instanceof NotFuture){
                   field.setAccessible(true);
                   try {
                       Date value = (Date)(field.get(pojo));
                       Date now = new Date();
                       if( (now.getTime() - value.getTime()) < 0)
                           return false;
                   } catch (IllegalArgumentException | IllegalAccessException ex) {
                       System.err.println(ex.toString());
                   }
               } if(annotation instanceof NotNull){
                   field.setAccessible(true);
                   try {
                       Object value = field.get(pojo);
                       if(value == null)
                           return false;
                   } catch (IllegalArgumentException | IllegalAccessException ex) {
                       System.err.println(ex.toString());
                   }
               } if(annotation instanceof StringValue){
                   StringValue stringValue = (StringValue) annotation;
                   field.setAccessible(true);
                   try {
                       String value = (String)field.get(pojo);
                       Pattern p = Pattern.compile(stringValue.pattern(), Pattern.CASE_INSENSITIVE);
                       Matcher m = p.matcher(value);
                       if(!m.matches())
                           return false;
                   } catch (ClassCastException ex) {
                       try {
                           String[] valueArray = (String[])field.get(pojo);
                           Pattern p = Pattern.compile(stringValue.pattern(), Pattern.CASE_INSENSITIVE);
                           for(String s : valueArray){
                               Matcher m = p.matcher(s);
                               if(!m.matches())
                                   return false;
                           }
                       } catch (ClassCastException exc) {
                           System.err.println(exc.toString());
                       } catch (IllegalArgumentException | IllegalAccessException exc) {
                           System.err.println(exc.toString());
                       }
                   } catch (IllegalArgumentException | IllegalAccessException ex) {
                       System.err.println(ex.toString());
                   }
               } 
               
           }
       }
       return true;
   }
    
    /**
     * Print POJO's contents to the standard output stream
     */
    private void printPojo(Object pojo){
       try {               
            MailMessage msg = (MailMessage)pojo;
            System.out.println("From: " + msg.getFrom());
            System.out.println("To: " + msg.getTo());
            
            System.out.print("CC: ");
            for(String str : msg.getCC())
                System.out.printf("%s, ", str);
            System.out.println();
            
            System.out.print("BCC: ");
            for(String str : msg.getBcc())
                System.out.printf("%s, ", str);
            System.out.println();
            
            String format = new SimpleDateFormat("dd.MM.yyyy").format(msg.getDate());
            System.out.println("Date: " + format);
            
            System.out.println("-------------");
            System.out.println();
        } catch(Exception ex)  {}
        try {
            Person msg = (Person)pojo;
            System.out.println("Fisrt: " + msg.getFirstName());
            System.out.println("Last: " + msg.getLastName());
            
            String format = new SimpleDateFormat("dd.MM.yyyy").format(msg.getBirthDay());
            System.out.println("DOB: " + format);
            
            System.out.println("-------------");
            System.out.println();
        } catch(Exception ex)  {}
   }
}
