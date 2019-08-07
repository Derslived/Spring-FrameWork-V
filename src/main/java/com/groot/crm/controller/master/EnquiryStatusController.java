/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groot.crm.controller.master;

import com.groot.crm.dto.EnquirySourceDTO;
import com.groot.crm.dto.EnquiryStatusDTO;
import com.groot.crm.entity.masters.EnquirySource;
import com.groot.crm.entity.masters.EnquiryStatus;
import com.groot.crm.service.EnquiryStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Derslived
 */
@Controller
@RequestMapping(value = "/admin/master/enquiry/status")
public class EnquiryStatusController extends CRUDController<EnquiryStatusDTO> {

    public EnquiryStatusController() {

        uriPath = "master/enquirystatus/";

    }

    @Autowired
    private EnquiryStatusService statusService;

//    @GetMapping
//    @Override
//    public String index(Model model) {
//
////        for(EnquiryStatus u: service.findAll()){
////            System.out.println(u.getColor());
////        }
//        model.addAttribute("statuses", statusService.findAll());
//        return "master/enquirystatus/index";
//
//    }
    @GetMapping(value = "/table")
    public String table(Model model) {
        model.addAttribute("statuses", statusService.findAll());
        return uriPath + "/components/status-table";
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public EnquiryStatus getDetail(@PathVariable("id") int id) {

        return statusService.findById(id);
    }

    @GetMapping(value = "/edit/{id}")
    @Override
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("status", statusService.findById(id));
        return "master/enquirystatus/edit";

    }

    @GetMapping(value = "/delete/{id}")
    @Override
    public String delete(@PathVariable("id") int id) {
        statusService.delete(id);
        return "redirect:/admin/master/enquiry/status";
    }

    @Override
    public String detail(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @PostMapping
    @Override
    public String save(EnquiryStatusDTO model) {
        statusService.save(model);
        return "redirect:/admin/master/enquiry/status";

    }

    @PostMapping(value = "save")
    @ResponseBody
    public Boolean saveJson(EnquiryStatusDTO model) {
        int result = statusService.save(model);

        return result > 0;
    }

}
