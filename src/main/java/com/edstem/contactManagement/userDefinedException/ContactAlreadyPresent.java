package com.edstem.contactManagement.userDefinedException;


public class ContactAlreadyPresent extends RuntimeException{

    public ContactAlreadyPresent(String msg){
        super(msg);
    }


}
