package com.edstem.contactManagement.controlLayer;

import com.edstem.contactManagement.module.Contact;
import com.edstem.contactManagement.serviceLayer.ContactServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/edstem")
public class ContactController {

    @Autowired
    private ContactServices contactServices;

    @PostMapping("/contact")
    public ResponseEntity<String> createContact(@Valid @RequestBody Contact contact){

        contactServices.createContact(contact);

        return new ResponseEntity<>("Contact Saved successfully", HttpStatus.OK);
    }

    @GetMapping("/contact")
    public ResponseEntity<List<Contact>> getAllContact(){
       List<Contact> contacts = contactServices.getAllContact();

       return new ResponseEntity<>(contacts,HttpStatus.OK);
    }

    @GetMapping("/contact/{key}")
    public ResponseEntity<List<Contact>> searchContact(@PathVariable("key") String key){
        List<Contact> contacts = contactServices.seachContact(key);

        return new ResponseEntity<>(contacts,HttpStatus.OK);
    }
}
