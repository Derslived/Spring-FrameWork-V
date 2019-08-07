/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groot.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Derslived
 */

@Controller
@RequestMapping(value="/")
public class HomeController {
    
    @Autowired
    private JdbcTemplate template;
    
    @GetMapping
    
    public String index(){
        
//          
        return "index";
        
    }
    
    
    
}
