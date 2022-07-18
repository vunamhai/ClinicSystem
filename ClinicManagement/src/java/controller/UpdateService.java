/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ServiceDAO;
import dao.UserDAO;
import dao.impl.ServiceDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Doctor;
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
 * @author Admin
 */
public class UpdateService extends HttpServlet {

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
        
        String serviceName = request.getParameter("service_name");
        String serviceBrief = request.getParameter("service_brief");
        String serviceDesc = request.getParameter("service_desc");
        int serviceId = Integer.parseInt(request.getParameter("service_id"));

        String[] ids = request.getParameter("list_doctors").split("-");
        List<Integer> idList = new ArrayList<>();

        if (!request.getParameter("list_doctors").equals("")) {
            for (String i : ids) {
                idList.add(Integer.parseInt(i));
            }
        }
        Service service = new Service();
        service.setServiceId(serviceId);
        service.setServiceName(serviceName);
        service.setServiceBrief(serviceBrief);
        service.setServiceDescription(serviceDesc);
        ServiceDAO serviceDAO = new ServiceDAOImpl();
        serviceDAO.removeAllDoctor(serviceId);
        serviceDAO.updateService(service);

        UserDAO userDAO = new UserDAOImpl();
        if (idList.isEmpty()) {
            userDAO.addDoctorForService(0, serviceId);
        }
        for (int k : idList) {
            userDAO.addDoctorForService(k, serviceId);
        }

        service = serviceDAO.getById(serviceId);

        List<Doctor> doctors = userDAO.getDoctorByServiceId(service.getServiceId());
        request.setAttribute("service", service);
        request.setAttribute("doctors", doctors);
        List<Doctor> allDoctors = userDAO.getAllDoctor();
        request.setAttribute("allDoctors", allDoctors);
        request.getRequestDispatcher("./jsp/editService.jsp").forward(request, response);

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
