package training.POJOs;

import training.Annotations.*;
import java.util.Date;

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
    public void setFirstName(String value){ firstName = value; }

    public String getLastName() { return lastName; }
    public void setLastName(String value){ lastName = value; }

    public Date getBirthDay() { return birthDay; }
    public void setBirthDay(Date value){ birthDay = value; }
}
