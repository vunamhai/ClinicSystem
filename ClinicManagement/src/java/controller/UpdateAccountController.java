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
public class UpdateAccountController extends HttpServlet {

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
        boolean update=true;
        int id= Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("username");
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String email=request.getParameter("email");
        String street=request.getParameter("street");
        String city=request.getParameter("city");
        String country=request.getParameter("country");
        String phone=request.getParameter("phone");
        int gender = Integer.parseInt(request.getParameter("gender"));
        Date dob=Date.valueOf(request.getParameter("dob"));
        Accounts a=new Accounts();
        a.setId(id);
        a.setUsername(username);
        a.setFirstname(firstname);
        a.setLastname(lastname);
        a.setEmail(email);
        a.setStreet(street);
        a.setCity(city);
        a.setCountry(country);
        a.setPhone(phone);
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
        if(acc1!=null){
            if(acc1.getId()==id){
                update=true;
            }
            else{
                update=false;
            }
        }
        if(acc2!=null&&update==true){
            if(acc2.getId()==id){
                update=true;
            }
            else{
                update=false;
            }
        }
        if(update){
            ad.updateAccounts(a);
        }
        ViewAllAccountController viewAllAccountController=new ViewAllAccountController();
        if(update==false){
            request.setAttribute("message", "Update failed");
        }
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
