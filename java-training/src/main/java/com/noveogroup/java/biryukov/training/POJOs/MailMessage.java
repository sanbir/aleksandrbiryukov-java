package com.noveogroup.java.biryukov.training.POJOs;

import com.noveogroup.java.biryukov.training.Annotations.*;

import java.util.*;

/**
 *  Mail Message.
 */
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
    public void setFrom(final String value) { from = value; }

    public String getTo() { return to; }
    public void setTo(final String value) { to = value; }

    public String[] getCC() { return cc.clone(); }
    public void setCC(final String[] value) { cc = value.clone(); }

    public String[] getBcc() { return bcc.clone(); }
    public void setBcc(final String[] value) { bcc = value.clone(); }

    public Date getDate() { return new Date(date.getTime()); }
    public void setDate(final Date value) { date = new Date(value.getTime()); }

    public String getMessage() { return message; }
    public void setMessage(final String value) { message = value; }
    
}
