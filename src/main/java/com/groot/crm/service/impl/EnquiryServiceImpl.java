/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groot.crm.service.impl;

import com.groot.crm.dto.EnquiryDTO;
import com.groot.crm.entity.masters.Enquires;
import com.groot.crm.repository.EnquiryRepository;
import com.groot.crm.service.EnquiryService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Derslived
 */

@Service
public class EnquiryServiceImpl implements EnquiryService {
    
    @Autowired
    private EnquiryRepository repository;
    
    
    @Autowired
    private ModelMapper mapper;
    

    @Override
    public int save(EnquiryDTO model) {

    Enquires enquiry = mapper.map(model, Enquires.class);
    
    if(model.getId()==0){
        return repository.insert(enquiry);
    }else{
        return repository.update(enquiry);
    }
    
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enquires> findAll() {

        return repository.getAll();
    
    }

    @Override
    public Enquires findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
