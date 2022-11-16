package com.edstem.contactManagement.serviceLayer;

import com.edstem.contactManagement.module.Contact;

import java.util.List;

public interface ContactServices {

    void createContact(Contact contact);

    List<Contact> getAllContact();

    List<Contact> seachContact(String key);

}
