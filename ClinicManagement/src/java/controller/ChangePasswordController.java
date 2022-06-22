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
import javax.servlet.http.HttpSession;

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
       response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts user = (Accounts) session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("./jsp/home.jsp").forward(request, response);
            return;
        }
          // password
        String oldPassword = request.getParameter("oldPassword").trim();
        String newPassword = request.getParameter("newPassword").trim();
        String reNewPassword = request.getParameter("reNewPassword").trim();
        session.setAttribute("oldPassword", oldPassword);
        session.setAttribute("newPassword", newPassword);
        session.setAttribute("reNewPassword", reNewPassword);

        if (!oldPassword.equals(user.getPassword())) {
            session.setAttribute("messageChangePass", "Old Passsword incorrect!!!");
            response.sendRedirect("./jsp/changePass.jsp");
            return;
        }

        if (!newPassword.equals(reNewPassword)) {
            session.setAttribute("messageChangePass", "Pass word not match!!!");
            response.sendRedirect("./jsp/changePass.jsp");
            return;
        }

        AccountDAOImpl userDAO = new AccountDAOImpl();
        userDAO.updatePassword(user.getUsername(), newPassword);
        session.removeAttribute("user");
        session.setAttribute("messageChangePass", "Password update success!!!");
        response.sendRedirect("./jsp/changePass.jsp");

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
