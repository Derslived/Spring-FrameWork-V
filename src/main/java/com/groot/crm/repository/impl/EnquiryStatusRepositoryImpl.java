/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groot.crm.repository.impl;


import com.groot.crm.entity.masters.EnquiryStatus;

import com.groot.crm.repository.EnquiryStatusRepository;
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
public class EnquiryStatusRepositoryImpl implements EnquiryStatusRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public int insert(EnquiryStatus model) {

        String sql = "insert into mst_enquiry_status(status_name,status_color) values(?,?)";

        return template.update(sql, new Object[]{model.getName(), model.getColor()});

    }

    @Override
    public int update(EnquiryStatus model) {

        String sql = "update mst_enquiry_status set status_name=?,status_color=?,modifed_date=CURRENT_TIMESTAMP where id=?";
               

        return template.update(sql, new Object[]{model.getName(), model.getColor(), model.getId()});

    }

    @Override
    public int delete(int id) {

        String sql = "update mst_enquiry_status set is_deleted=1,deleted_date=CURRENT_TIMESTAMP where id=?";

        return template.update(sql, new Object[]{id});

    }

    @Override
    public List<EnquiryStatus> getAll() {

        String sql = "select * from vw_enquiry_status";
        return template.query(sql, new RowMapper<EnquiryStatus>() {

            @Override
            public EnquiryStatus mapRow(ResultSet rs, int i) throws SQLException {

                EnquiryStatus status = new EnquiryStatus();
                status.setId(rs.getInt("id"));
                status.setName(rs.getString("status_name"));
                status.setColor(rs.getString("status_color"));
                status.setCreatedDate(rs.getDate("created_date"));
                status.setModifiedDate(rs.getDate("modifed_date"));
                
                return status;

            }
        });

    }

    @Override
    public EnquiryStatus findById(int id) {

        String sql = "select * from mst_enquiry_status where id=?";

        return template.queryForObject(sql, new Object[]{id}, new RowMapper<EnquiryStatus>() {

            @Override
            public EnquiryStatus mapRow(ResultSet rs, int i) throws SQLException {

                EnquiryStatus status = new EnquiryStatus();
                status.setId(rs.getInt("id"));
                status.setName(rs.getString("status_name"));
                status.setColor(rs.getString("status_color"));
                status.setCreatedDate(rs.getDate("created_date"));
                status.setModifiedDate(rs.getDate("modifed_date"));
                
                return status;

            }
        });

    }

}
