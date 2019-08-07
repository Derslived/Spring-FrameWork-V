/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groot.crm.service;

import java.util.List;

/**
 *
 * @author Derslived
 */
public interface GenericService<TDTO, TModel> {
    
    
    int save(TDTO model);
    int delete(int id);
    List<TModel> findAll();
    TModel findById(int id);
    
    
}
