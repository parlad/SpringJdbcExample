/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.springJDBC.DAO;

import com.neupane.springJDBC.entity.Customer;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author parlad
 */
public interface CustomerDAO {

    int insert(Customer c) throws ClassNotFoundException, SQLException;

    int update(Customer c) throws ClassNotFoundException, SQLException;
    
    void delete(int id) throws ClassNotFoundException, SQLException;

    List<Customer> getAll() throws ClassNotFoundException, SQLException;

    Customer getById(int id) throws ClassNotFoundException, SQLException;

}
