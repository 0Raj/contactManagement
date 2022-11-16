package com.edstem.contactManagement.serviceLayer;

import com.edstem.contactManagement.module.Contact;
import com.edstem.contactManagement.repositoryLayer.ContactDAO;
import com.edstem.contactManagement.userDefinedException.ContactAlreadyPresent;
import com.edstem.contactManagement.userDefinedException.ContactNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactServices{

    @Autowired
    private ContactDAO contactDAO;

    @Override
    public void createContact(Contact contact) {

        Optional<Contact> optionalContact = contactDAO.findById(contact.getPhoneNumer());

        if(optionalContact.isPresent()){
            throw new ContactAlreadyPresent("Contact Already present would you like to update");
        }

        contactDAO.save(contact);

    }

    @Override
    public List<Contact> getAllContact() {

        List<Contact> contactList =  contactDAO.findAll();

        if (contactList.size() == 0){
            throw new ContactNotFound("No contact found please add some");
        }

        return contactList;
    }

    @Override
    public List<Contact> seachContact(String key) {
        key = key.toLowerCase();
        List<Contact> contactList = getAllContact();

        List<Contact> resultList = new ArrayList<>();

        for(Contact contact : contactList){
            String name = contact.getFirstName().toLowerCase();
            String secondName = contact.getLastName().toLowerCase();
            if(name.equalsIgnoreCase(key) || name.contains(key) || name.startsWith(key) ||
                    secondName.equalsIgnoreCase(key) || secondName.contains(key) || secondName.startsWith(key)){
                resultList.add(contact);
            }
        }

        if(resultList.size() == 0){
            throw new ContactNotFound("No contact found for your search please provide valid name");
        }


        return resultList;
    }
}
