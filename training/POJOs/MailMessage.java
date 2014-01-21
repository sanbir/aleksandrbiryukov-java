package training.POJOs;

import training.Annotations.*;
import java.util.*;

public class MailMessage implements java.io.Serializable {
    
    @NotBlank
    @NotNull
    @StringValue(pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String from;
    
    @NotBlank
    @NotNull
    @StringValue(pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String to;
    
    @Nullable
    @StringValue(pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String[] cc;
    
    @Nullable
    @StringValue(pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String[] bcc;
    
    @NotNull
    @NotFuture
    private Date date;
    
    @Nullable
    private String message;
    
    /* getters and setters */
    
    public String getFrom() { return from; } 
    public void setFrom(String value){ from = value; }
    
    public String getTo(){ return to; }   
    public void setTo(String value){ to = value; }
    
    public String[] getCC(){ return cc; }    
    public void setCC(String[] value){ cc = value; }
    
    public String[] getBcc(){ return bcc; }    
    public void setBcc(String[] value){ bcc = value; }
    
    public Date getDate(){ return date; }    
    public void setDate(Date value){ date = value; }
    
    public String getMessage(){ return message; }   
    public void setMessage(String value){ message = value; }
    
}
