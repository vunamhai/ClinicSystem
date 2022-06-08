/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.AccountDAOImpl;
import entity.Accounts;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nam Ngo
 */
public class AddAccountController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username=request.getParameter("username");
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String email=request.getParameter("email");
        String street=request.getParameter("street");
        String city=request.getParameter("city");
        String country=request.getParameter("country");
        String phone=request.getParameter("phone");
        String password=request.getParameter("password");
        int gender = Integer.parseInt(request.getParameter("gender"));
        Date dob=Date.valueOf(request.getParameter("dob"));
        Accounts a=new Accounts();
        a.setUsername(username);
        a.setFirstname(firstname);
        a.setLastname(lastname);
        a.setEmail(email);
        a.setStreet(street);
        a.setCity(city);
        a.setCountry(country);
        a.setPhone(phone);
        a.setPassword(password);
        if(gender==1){
            a.setGender(true);
        }
        else{
            a.setGender(false);
        }
        a.setDob(dob);
        
        AccountDAOImpl ad=new AccountDAOImpl();
        Accounts acc1=ad.getAccountByEmail(email);
        Accounts acc2=ad.getAccountByUsername(username);
        if(acc1!=null||acc2!=null){
            request.setAttribute("message", "Add failed");
        }
        else{
            ad.addAccounts(a);
        }
        ViewAllAccountController viewAllAccountController=new ViewAllAccountController();
        viewAllAccountController.processRequest(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
