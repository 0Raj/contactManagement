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
    private String phoneNumer;

    private String firstName;

    private String lastName;

    @Email
    private String emailID;

    private String address;
}
