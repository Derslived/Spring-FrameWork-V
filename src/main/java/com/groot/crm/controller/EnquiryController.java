/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groot.crm.controller;

import com.groot.crm.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Derslived
 */

@Controller
@RequestMapping(value="/admin/enquires")
public class EnquiryController {
    
    @Autowired
    private EnquiryService service;
    
    
    @GetMapping
    
    public String index(Model model){
        
        model.addAttribute("enquires", service.findAll());
         
        
        
        
        return "/admin/enquires/index";
    }
    
    
}
