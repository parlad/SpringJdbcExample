/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.springJDBC.DAO.Impl;

import com.neupane.springJDBC.DAO.CustomerDAO;
import com.neupane.springJDBC.entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author parlad
 */
@Repository(value = "departmentDAO")
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplet;

    @Override
    public int insert(Customer c) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO customer (first_name,last_name,address,email,contact,status) VALUES (?,?,?,?,?,?)";
        return jdbcTemplet.update(sql, new Object[]{c.getFirstName(), c.getLastName(), c.getAddress(), c.getEmail(), c.getContact(), c.isStatus()});
    }

    @Override
    public int update(Customer c) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE customer SET first_name=?,last_name = ?,address = ?,email=?,contact=?,status=? WHERE id=?";
        return jdbcTemplet.update(sql, new Object[]{c.getFirstName(), c.getLastName(), c.getAddress(), c.getEmail(), c.getContact(), c.isStatus(), c.getCustomerId()});
    }

    @Override
    public List<Customer> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM customer";
        return jdbcTemplet.query(sql, new RowMapper<Customer>() {

            @Override
            public Customer mapRow(ResultSet rs, int i) throws SQLException {
                Customer cust = new Customer();
                cust.setCustomerId(rs.getInt("id"));
                cust.setFirstName(rs.getString("first_name"));
                cust.setLastName(rs.getString("last_name"));
                cust.setAddress(rs.getString("address"));
                cust.setEmail(rs.getString("email"));
                cust.setContact(rs.getInt("contact"));
                cust.setStatus(Boolean.parseBoolean(rs.getString("status")));
                return cust;
            }
        });
    }

    @Override
    public Customer getById(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FORM customer WHERE id=?";
        jdbcTemplet.update(sql, new Object[]{id});

    }

}
