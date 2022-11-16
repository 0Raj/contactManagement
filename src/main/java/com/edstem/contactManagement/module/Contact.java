package com.edstem.contactManagement.module;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class Contact {

    @Id
    @Pattern(regexp = "[6-9]{1}[0-9]{9}",message = "Mobile number should start with 6,7,8 or 9 and it should have 10 digits")
    private String phoneNumer;

    @Pattern(regexp = "[a-zA-Z]{3}",message = "Name should have atlease 3 characters")
    private String firstName;

    private String lastName;

    @Email
    private String emailID;

    private String address;
}
