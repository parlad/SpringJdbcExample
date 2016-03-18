/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.springJDBC.controller;

import com.neupane.springJDBC.DAO.CustomerDAO;
import com.neupane.springJDBC.entity.Customer;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author parlad
 */
@Controller
@RequestMapping(value = "/")
public class CustomerControler {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() throws ClassNotFoundException, SQLException {
        ModelAndView mv = new ModelAndView("index");
        try {
            mv.addObject("customer", customerDAO.getAll());
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }
        return mv;
    }
}
