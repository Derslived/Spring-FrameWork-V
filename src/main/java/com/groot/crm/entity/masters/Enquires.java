/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groot.crm.entity.masters;

import com.groot.crm.entity.common.MasterEntity;
import java.util.Date;

/**
 *
 * @author Derslived
 */
public class Enquires extends MasterEntity {
    
    private String firstName,lastName,email,contactNumber;
    private EnquirySource source;
    private EnquiryStatus status;
    private Boolean visited;
    private Date visitDate;
    private String refered;
    private int createdBy;
    private String ipAddress;

    public Enquires() {
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

    public EnquirySource getSource() {
        return source;
    }

    public void setSource(EnquirySource source) {
        this.source = source;
    }

    public EnquiryStatus getStatus() {
        return status;
    }

    public void setStatus(EnquiryStatus status) {
        this.status = status;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getRefered() {
        return refered;
    }

    public void setRefered(String refered) {
        this.refered = refered;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "Enquires{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", contactNumber=" + contactNumber + ", source=" + source + ", status=" + status + ", visited=" + visited + ", visitDate=" + visitDate + ", refered=" + refered + ", createdBy=" + createdBy + ", ipAddress=" + ipAddress + '}';
    }
    
    
    
    
    
    
    
}
