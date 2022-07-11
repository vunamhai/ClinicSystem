/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ReservationDAO;
import dao.ServiceDAO;
import dao.impl.ReservationDAOImpl;
import dao.impl.ServiceDAOImpl;
import entity.Reservation;
import entity.Service;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Utils;

/**
 *
 * @author nguyen
 */
public class ViewAllReservationsController extends HttpServlet {

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
              HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            String viewDay = (request.getParameter("viewDay") != null) ? Utils.parseDateFormat(request.getParameter("viewDay").trim()) : Utils.getToday();
            int serviceId = (request.getParameter("serviceId") != null) ? Integer.parseInt(request.getParameter("serviceId").trim()) : -1;
            ServiceDAO serviceDAO = new ServiceDAOImpl(); // get serviceDAO object
            ReservationDAO reservationDAO = (ReservationDAO) new ReservationDAOImpl();// get reservationDAO object
            ArrayList<Service> services = serviceDAO.getServices();
            ArrayList<User> doctors = reservationDAO.getDoctorsHasReservation(viewDay, serviceId);
            ArrayList<Reservation> reservations = reservationDAO.getReservationsByDay(viewDay, serviceId);

            request.setAttribute("viewDay", Utils.revertParseDateFormat(viewDay));
            request.setAttribute("serviceId", serviceId);
            request.setAttribute("doctors", doctors);
            request.setAttribute("services", services);
            request.setAttribute("reservations", reservations);
            request.getRequestDispatcher("jsp/viewAllReservation.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Không thể tải dữ liệu từ cơ sở dữ liệu");
            request.setAttribute("exceptionMessage", e.getMessage());
            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
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
