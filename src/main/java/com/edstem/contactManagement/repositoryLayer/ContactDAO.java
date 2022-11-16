package com.edstem.contactManagement.repositoryLayer;

import com.edstem.contactManagement.module.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDAO extends JpaRepository<Contact,String> {
}
