/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groot.crm.service.impl;

import com.groot.crm.dto.EnquiryStatusDTO;

import com.groot.crm.entity.masters.EnquiryStatus;

import com.groot.crm.repository.EnquiryStatusRepository;

import com.groot.crm.service.EnquiryStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Derslived
 */
@Service
public class EnquiryStatusServiceImpl implements EnquiryStatusService {

    @Autowired
    private EnquiryStatusRepository repository;

    @Override
    public int save(EnquiryStatusDTO model) {

        EnquiryStatus status = new EnquiryStatus();
        status.setId(model.getId());
        status.setName(model.getName());
        status.setColor(model.getColor());

        if (status.getId() == 0) {
            return repository.insert(status);
        } else {
            return repository.update(status);
        }

    }

    @Override
    public int delete(int id) {

        return repository.delete(id);

    }

    @Override
    public List<EnquiryStatus> findAll() {

        return repository.getAll();
    }

    @Override
    public EnquiryStatus findById(int id) {

        return repository.findById(id);
    }

}
