/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groot.crm.dto;

/**
 *
 * @author Derslived
 */
public class EnquiryDTO {
    
    private int id;
    private String firstName,lastName,email,contactNumber,referedBy;
    private int statusId,sourceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getReferedBy() {
        return referedBy;
    }

    public void setReferedBy(String referedBy) {
        this.referedBy = referedBy;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int enquiryStatus) {
        this.statusId = enquiryStatus;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int enquirySource) {
        this.sourceId = enquirySource;
    }
    
    
      
    
}
