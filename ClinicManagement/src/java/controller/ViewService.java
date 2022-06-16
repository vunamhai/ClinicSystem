/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.ServiceDAOImpl;
import entity.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author TuDA
 */
public class ViewService extends HttpServlet {

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
//         String id = request.getParameter("idService");
//        ServiceDAOImpl sdi = new ServiceDAOImpl();
//        Service service = sdi.getById(Integer.parseInt(id));
//        PrintWriter out = response.getWriter();
//        try  {
//            /* TODO output your page here. You may use following sample code. */
//            String modalHtmlComponent = " <div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n"
//                    + "                <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n"
//                    + "                    <div class=\"modal-content\">\n"
//                    + "                        <div class=\"modal-header border-bottom-0\">\n"
//                    + "                            <h5 class=\"modal-title\" id=\"exampleModalLabel\">Update</h5>\n"
//                    + "                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n"
//                    + "                                <span aria-hidden=\"true\">&times;</span>\n"
//                    + "                            </button>\n"
//                    + "                        </div>\n"
//                    + "                        <form action=\"UpdateService\" method=\"POST\">\n"
//                    + "                            <div class=\"modal-body\">\n"
//                    + "\n"
//                    + "                                <div class=\"form-group\">\n"
//                    + "                                    <label for=\"status\">Name</label>\n"
//                    + "                                    <input type=\"text\"  class=\"form-control\" id=\"code\" name=\"" + service.getServiceName() + "\">\n"
//                    + "                                </div>\n"
//                    + "                                <div class=\"form-group\">\n"
//                    + "                                    <label for=\"image\">Description</label>\n"
//                    + "                                    <input type=\"text\"  class=\"form-control\" id=\"image\" name=\"" + service.getServiceDescription() + "\">\n"
//                    + "                                </div>\n"
//                    + "                            </div>\n"
//                    + "                            <div class=\"modal-footer border-top-0 d-flex justify-content-center\">\n"
//                    + "                                <button type=\"submit\" class=\"btn btn-success\">Submit</button>\n"
//                    + "                            </div>\n"
//                    + "                        </form>\n"
//                    + "                    </div>\n"
//                    + "                </div>\n"
//                    + "            </div>";
//        out.println(modalHtmlComponent);
//        } catch (Exception ex) {
//            out.println("Lỗi hệ thống xxxx.");
//        }
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
        String id = request.getParameter("id");
        System.out.println("xxxxxxxxxxxxxxxxxxxxx" + id);
        ServiceDAOImpl sdi = new ServiceDAOImpl();
        ArrayList<entity.ViewServiceX> viewService = null;
        try {
            viewService = sdi.viewServices(Integer.parseInt(id));
        } catch (SQLException ex) {
            Logger.getLogger(ViewService.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("viewService", viewService);
        request.getRequestDispatcher("jsp/ViewService.jsp").forward(request, response);
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
