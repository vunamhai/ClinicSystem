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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ChangePasswordController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePasswordController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePasswordController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
               int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        request.getRequestDispatcher("jsp/changePassword.jsp").forward(request, response);
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
      PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        AccountDAOImpl aOImpl = new AccountDAOImpl();
        Accounts a = aOImpl.getAccountById(id);
        try {
            String oldP = request.getParameter("oldPassword");
            if (oldP.equals("") || oldP == null) {
                throw new Exception();
            }
            String newP = request.getParameter("newPassword");
            if (newP.equals("") || newP == null) {
                throw new Exception();
            }
            String reNewP = request.getParameter("reNewPassword");
            if (reNewP.equals("") || reNewP == null) {
                throw new Exception();
            }
            if (oldP.equals(a.getPassword())!=true) {
                out.println("<script type=\"text/javascript\">\n"
                        + "alert('Old password not match!');\n"
                        + "location= 'ChangePasswordController?id=" + id + "';\n"
                        + "</script>");
            }
            if (newP.equals(reNewP) != true) {
                out.println("<script type=\"text/javascript\">\n"
                        + "alert('New password not match with confirm password!');\n"
                        + "location= 'ChangePasswordController?id=" + id + "';\n"
                        + "</script>");
            }
            if (newP.equals(reNewP) && oldP.equals(a.getPassword())) {
                int check = aOImpl.updatePasswordById(id, newP);
                if (check == 1) {
                    out.println("<script type=\"text/javascript\">\n"
                            + "alert('Change password successfully!');\n"
                            + "location= 'http://localhost:8080/ClinicManagement/jsp/login.jsp';\n"
                            + "</script>");
                } else {
                    out.println("<script type=\"text/javascript\">\n"
                            + "alert('Change password unsuccessfully!');\n"
                            + "location= 'ChangePasswordController?id=" + id + "';\n"
                            + "</script>");
                }
            }
        } catch (Exception e) {
            out.println("<script type=\"text/javascript\">\n"
                    + "alert('Change password unsuccessfully!');\n"
                    + "location= 'ChangePasswordController?id=" + id + "';\n"
                    + "</script>");
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