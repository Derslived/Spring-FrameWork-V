/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groot.crm.entity.masters;

import com.groot.crm.entity.common.MasterEntity;

/**
 *
 * @author Derslived
 */
public class EnquiryStatus extends MasterEntity {

    private String name;
    private String color;

    public EnquiryStatus() {
    }

    public EnquiryStatus(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
