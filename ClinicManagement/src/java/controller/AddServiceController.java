/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ServiceDAO;
import dao.impl.ServiceDAOImpl;
import entity.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author uyenc
 */
public class AddServiceController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
            String[] ids = new String[10];
        if (request.getParameter("list_doctors") != null) {
            ids = request.getParameter("list_doctors").split("-");
        }
        List<Integer> idList = new ArrayList<>();
        
        if (request.getParameter("list_doctors") != null) {
            for (String i : ids) {
                idList.add(Integer.parseInt(i));
            }
        }
        
        String serviceName = request.getParameter("serviceName");
        String serviceBrief = request.getParameter("serviceDescription");
        Service service = new Service();
        service.setServiceName(serviceName);
        service.setServiceDescription(serviceBrief);
        ServiceDAO serviceDAO = new ServiceDAOImpl();
        serviceDAO.addService(service);
        
        int key = serviceDAO.getIdInserted();
        for (int k : idList) {
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
        String name = request.getParameter("serviceName");
        String description = request.getParameter("serviceDescription");
        ServiceDAOImpl sdi = new ServiceDAOImpl();
        Service service = new Service(name, description);
        sdi.addServiceX(service);
        request.getRequestDispatcher("jsp/serviceManagementList.jsp").forward(request, response);
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
