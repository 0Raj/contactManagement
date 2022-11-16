package com.edstem.contactManagement.userDefinedException;


public class ContactNotFound extends RuntimeException{

    public ContactNotFound(String msg){
        super(msg);
    }


}
