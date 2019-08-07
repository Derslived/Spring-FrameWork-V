/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groot.crm.repository.impl;

import com.groot.crm.entity.masters.Enquires;
import com.groot.crm.entity.masters.EnquirySource;
import com.groot.crm.entity.masters.EnquiryStatus;
import com.groot.crm.repository.EnquiryRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Derslived
 */
@Repository
public class EnquiryRepositoryImpl implements EnquiryRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public int insert(Enquires model) {

        String sql = "insert into tbl_enquires(first_name,last_name,email,contact_no,enquiry_source_id,enquiry_status_id,refered_by)"
                + " values(?,?,?,?,?,?,?)";

        return template.update(sql, new Object[]{
            model.getFirstName(), model.getLastName(), model.getEmail(), model.getContactNumber(), model.getSource().getId(), model.getStatus().getId(), model.getRefered()

        });

    }

    @Override
    public int update(Enquires model) {

        String sql = "update tbl_enquires set first_name=?,last_name=?,email=?,contact_no=?,enquiry_source_id=?,enquiry_status_id=?, created_date=CURRENT_TIMESTAMP,refered_by=?";

        return template.update(sql, new Object[]{
            model.getFirstName(), model.getLastName(), model.getEmail(), model.getContactNumber(), model.getSource().getId(), model.getStatus().getId(), model.getRefered()
        });

    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enquires> getAll() {
  
        String sql="select enq.*,sts.status_name,sts.status_color,"
                + "src.source_name,src.source_color from tbl_enquires enq"
                
                + " LEFT JOIN vw_enquiry_status sts on sts.id=enq.enquiry_status_id"
                + " LEFT JOIN  vw_enquiry_source src on src.id=enq.enquiry_source_id";
        return template.query(sql, new RowMapper<Enquires>() {

            @Override
            public Enquires mapRow(ResultSet rs, int i) throws SQLException {
         
            Enquires enquiry = new Enquires();
            enquiry.setId(rs.getInt("id"));
            enquiry.setFirstName(rs.getString("first_name"));
            enquiry.setLastName(rs.getString("last_name"));
            enquiry.setEmail(rs.getString("email"));
            enquiry.setContactNumber(rs.getString("contact_no"));
            enquiry.setRefered(rs.getString("refered_by"));
            enquiry.setSource(new EnquirySource(rs.getInt("enquiry_source_id"),
            rs.getString("source_name"),rs.getString("source_color")));
            enquiry.setStatus(new EnquiryStatus(rs.getInt("enquiry_status_id"),
            rs.getString("status_name"),rs.getString("status_color")));
            enquiry.setCreatedDate(rs.getDate("created_date"));
            enquiry.setVisited(rs.getBoolean("is_visited"));
            
            return enquiry;
            
            
            }
        });
    
    
    
    
    
    }

    @Override
    public Enquires findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
