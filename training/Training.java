package training;

import training.Buffers.*;
import training.POJOs.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import static training.Resources.*;

/**
 *  The main class - entry point
 */
public class Training {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException { 
        stage1();
        stage2();
    }
    
    /**
    *  The first stage including POJO generation, serialization and writing to file
    */
    private static void stage1() throws IOException{
        Collection<Object> pojosToWrite = new LinkedList<>();
        
        /* Receiving user input */
        int n;
        System.out.println("How many VALID Mail Messages would you like to get?");       
        n = sc.nextInt();     
        for(int i = 0; i < n; i++){
            pojosToWrite.add(generateValidPojo(POJOs.MailMessage));
        }
        System.out.println("How many INVALID Mail Messages would you like to get?");       
        n = sc.nextInt(); 
        for(int i = 0; i < n; i++){
            pojosToWrite.add(generateInvalidPojo(POJOs.MailMessage));
        }
        System.out.println("How many VALID Persons would you like to get?");       
        n = sc.nextInt(); 
        for(int i = 0; i < n; i++){
            pojosToWrite.add(generateValidPojo(POJOs.Person));
        }
        System.out.println("How many INVALID Persons would you like to get?");       
        n = sc.nextInt(); 
        for(int i = 0; i < n; i++){
            pojosToWrite.add(generateInvalidPojo(POJOs.Person));
        }
        
        /* Persisting data */
        
        ObjectOutputStream oos = new ObjectOutputStream 
                (new FileOutputStream("serial.bin") );
        for(Object obj : pojosToWrite)
            oos.writeObject(obj);
       
    }
    
    /**
    *  The second stage - reading POJOs from file and validation
    */    
    private static void stage2() throws IOException{
        /* Receiving user input */
        System.out.println("Would you like to do synchronize-wait-notify [0]"
                + System.lineSeparator()
                + "or java concurrency framework? [1]"
                + System.lineSeparator()
                + "(Default: 0)");
        int n;
        try {
            n = sc.nextInt();
        } catch(Exception ex){
            n = 0;
        }
        
        /* choice between synchronize-wait-notify and java concurrency framework */
        Buffer buffer;
        if(n == 1){
            buffer = new BufferBlockingQueueAdapter(new LinkedBlockingQueue());
        } else {
            buffer = new BufferSyncWN();
        }

        Reader producer = new Reader(buffer);
        Worker consumer = new Worker(buffer);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    /**
    *  POJO is automatically randomly generated from existing classes
    * in training.POJOs package.
    * Its fields are filled using static arrays from training.Resources
    * There are currently only 2 types for POJOs: MailMessage and Person.
    * Here only valid POJO is generated. 
    * For invalid one use 'generateInvalidPojo' method.
    */ 
    private static Object generateValidPojo(POJOs pojoType){
        Random rand = new Random();     
        
        if(pojoType == POJOs.MailMessage){
            MailMessage pojo = new MailMessage();
            pojo.setFrom(VALID_EMAIL_ADDRESSES[rand.nextInt(VALID_EMAIL_ADDRESSES.length)]);
            pojo.setTo(VALID_EMAIL_ADDRESSES[rand.nextInt(VALID_EMAIL_ADDRESSES.length)]);     
            pojo.setCC(Arrays.copyOfRange(VALID_EMAIL_ADDRESSES, 6, 18));
            pojo.setBcc(Arrays.copyOfRange(VALID_EMAIL_ADDRESSES, 27, 34));

            Calendar cal = new GregorianCalendar(2013, rand.nextInt(12), rand.nextInt(31)+1);
            Date date = cal.getTime();               
            pojo.setDate(date);

            pojo.setMessage("");
            
            return pojo;
        }

        if(pojoType == POJOs.Person){
            Person pojo = new Person();
            pojo.setFirstName(VALID_FIRST_NAMES[rand.nextInt(VALID_FIRST_NAMES.length)]);
            pojo.setLastName(VALID_LAST_NAMES[rand.nextInt(VALID_LAST_NAMES.length)]);     

            Calendar cal = new GregorianCalendar(rand.nextInt(10)+1970, rand.nextInt(12), rand.nextInt(31)+1);
            Date date = cal.getTime();               
            pojo.setBirthDay(date);
            
            return pojo;
        }
        
        return null; // Should not be ever reached
    }
 
    /**
    *  POJO is automatically randomly generated from existing classes
    * in training.POJOs package.
    * Its fields are filled using static arrays from training.Resources
    * There are currently only 2 types for POJOs: MailMessage and Person.
    * Here only INvalid POJO is generated. 
    * For valid one use 'generateValidPojo' method.
    */ 
    private static Object generateInvalidPojo(POJOs pojoType){
        Random rand = new Random();     
        
        if(pojoType == POJOs.MailMessage){
            MailMessage pojo = new MailMessage();
            pojo.setFrom(VALID_EMAIL_ADDRESSES[rand.nextInt(VALID_EMAIL_ADDRESSES.length)]);
            pojo.setTo(VALID_EMAIL_ADDRESSES[rand.nextInt(VALID_EMAIL_ADDRESSES.length)]);     
            pojo.setCC(Arrays.copyOfRange(VALID_EMAIL_ADDRESSES, 6, 18));
            pojo.setBcc(Arrays.copyOfRange(INVALID_EMAIL_ADDRESSES, 1, 9));

            Calendar cal = new GregorianCalendar(2013, rand.nextInt(12), rand.nextInt(31)+1);
            Date date = cal.getTime();               
            pojo.setDate(date);

            pojo.setMessage("");
            
            return pojo;
        }
        if(pojoType == POJOs.Person){
            Person pojo = new Person();
            pojo.setFirstName(INVALID_FIRST_NAMES[rand.nextInt(INVALID_FIRST_NAMES.length)]);
            pojo.setLastName(INVALID_FIRST_NAMES[rand.nextInt(INVALID_FIRST_NAMES.length)]);     

            Calendar cal = new GregorianCalendar(rand.nextInt(10)+2015, rand.nextInt(12), rand.nextInt(31)+1);
            Date date = cal.getTime();               
            pojo.setBirthDay(date);
            
            return pojo;
        }
        
        return null; // Should not be ever reached
    }    
}
