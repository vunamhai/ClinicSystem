/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.impl.AccountDAOImpl;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nguyen Van Nam
 */
public class RegisterForCustomerController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String firstname = request.getParameter("firstname").trim();
         String lastname = request.getParameter("lastname").trim();
          String username = request.getParameter("username").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String rePassword = request.getParameter("re-password").trim();
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        
        String date = request.getParameter("date").trim();
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        java.util.Date jdate = format.parse(date);
        java.util.Date today = new java.util.Date();
        String phone = request.getParameter("phone").trim();
        String street = request.getParameter("street").trim();
        String city = request.getParameter("city").trim();
        String country = request.getParameter("country").trim();
       
        HttpSession session = request.getSession();
        
        session.setAttribute("firstname", firstname);
        session.setAttribute("lastname", lastname);
        session.setAttribute("username", username);
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        session.setAttribute("rePassword", rePassword);
        session.setAttribute("phone", phone);
        session.setAttribute("street", street);
        session.setAttribute("city", city);
        session.setAttribute("country", country);
        session.setAttribute("date", date);

        
        session.removeAttribute("message");
        if (jdate.after(today)) {
            session.setAttribute("message", "Date invalid");
            response.sendRedirect("./jsp/Register.jsp");
            return;
        }
        int check = Integer.parseInt(request.getParameter("gender").trim());
        boolean gender;
        if (check == 1) {
            gender = true;
        } else {
            gender = false;
        }
        if (!password.equals(rePassword)) {
            session.setAttribute("message", "Password not match");
            response.sendRedirect("./jsp/Register.jsp");
            return;
        }
        
        java.sql.Date sdate = new java.sql.Date(jdate.getTime());
        request.setAttribute("date", sdate);
        
        
        
        Account account = new Account(username, email, password, firstname, lastname, sdate, gender, phone, street, city, country);
        AccountDAO userDAO = new AccountDAOImpl();
        
        if (userDAO.login(username, password) != null) {
            session.setAttribute("message", "Username existed");
        } else {
            userDAO.createAccount(account);
            session.setAttribute("message", "Register Successfully");
        }
        response.sendRedirect("./jsp/Register.jsp");
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RegisterForCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RegisterForCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}


