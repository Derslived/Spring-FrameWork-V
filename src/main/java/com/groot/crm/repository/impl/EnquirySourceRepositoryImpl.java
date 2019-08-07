/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groot.crm.repository.impl;

import com.groot.crm.entity.masters.EnquirySource;
import com.groot.crm.repository.EnquirySourceRepository;
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
public class EnquirySourceRepositoryImpl implements EnquirySourceRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public int insert(EnquirySource model) {

        String sql = "insert into mst_enquiry_sources(source_name,source_color) values(?,?)";

        return template.update(sql, new Object[]{model.getName(), model.getColor()});

    }

    @Override
    public int update(EnquirySource model) {

        String sql = "update mst_enquiry_sources set source_name=?,source_color=?,modified_date=CURRENT_TIMESTAMP where id=?";
               

        return template.update(sql, new Object[]{model.getName(), model.getColor(), model.getId()});

    }

    @Override
    public int delete(int id) {

        String sql = "update mst_enquiry_sources set is_deleted=1,deleted_date=CURRENT_TIMESTAMP where id=?";

        return template.update(sql, new Object[]{id});

    }

    @Override
    public List<EnquirySource> getAll() {

        String sql = "select * from vw_enquiry_source";
        return template.query(sql, new RowMapper<EnquirySource>() {

            @Override
            public EnquirySource mapRow(ResultSet rs, int i) throws SQLException {

                EnquirySource source = new EnquirySource();
                source.setId(rs.getInt("id"));
                source.setName(rs.getString("source_name"));
                source.setColor(rs.getString("source_color"));
                source.setCreatedDate(rs.getDate("created_date"));
                source.setModifiedDate(rs.getDate("modified_date"));
                
                return source;

            }
        });

    }

    @Override
    public EnquirySource findById(int id) {

        String sql = "select * from mst_enquiry_sources where id=?";

        return template.queryForObject(sql, new Object[]{id}, new RowMapper<EnquirySource>() {

            @Override
            public EnquirySource mapRow(ResultSet rs, int i) throws SQLException {

                EnquirySource source = new EnquirySource();
                source.setId(rs.getInt("id"));
                source.setName(rs.getString("source_name"));
                source.setColor(rs.getString("source_color"));
                source.setModifiedDate(rs.getDate("modified_date"));
                source.setCreatedDate(rs.getDate("created_date"));
                return source;

            }
        });

    }

}
