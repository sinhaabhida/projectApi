/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author mohil
 */
public class MyFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        sr.getRequestDispatcher("viewEmployee").forward(sr, sr1);
    }
    
}
