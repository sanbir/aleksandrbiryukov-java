package com.noveogroup.java.biryukov.training.POJOs;

import com.noveogroup.java.biryukov.training.Annotations.NotBlank;
import com.noveogroup.java.biryukov.training.Annotations.NotFuture;
import com.noveogroup.java.biryukov.training.Annotations.NotNull;
import com.noveogroup.java.biryukov.training.Annotations.StringValue;

import java.util.Date;

/**
 *  Person.
 */
public class Person implements java.io.Serializable {
    @NotBlank
    @NotNull
    @StringValue(pattern = "([a-zA-Z]{3,30}\\s*)+")
    private String firstName;

    @NotBlank
    @NotNull
    @StringValue(pattern = "^[a-zA-Z\\s]+(([\\'\\,\\.\\-][a-zA-Z])?[a-zA-Z]*)*$")
    private String lastName;

    @NotNull
    @NotFuture
    private Date birthDay;
    
    /* getters and setters */
    
    public String getFirstName() { return firstName; }
    public void setFirstName(final String value) { firstName = value; }

    public String getLastName() { return lastName; }
    public void setLastName(final String value) { lastName = value; }

    public Date getBirthDay() { return new Date(birthDay.getTime()); }
    public void setBirthDay(final Date value) { birthDay = new Date(value.getTime()); }
}
