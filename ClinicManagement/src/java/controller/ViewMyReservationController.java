/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 tungnt           First Implement 
 */
package controller;

import dao.ReservationDAO;
import dao.impl.ReservationDAOImpl;
import entity.Reservation;
import entity.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Utils;

/**
 * * -This class uses function getMyReservations in
 * <code>dao.impl.reservationDAOImpl</code> to get an
 * <code>java.util.ArrayList</code> object that contains a series of
 * <code>entity.Reservation</code>
 *
 * @author Nguyen Thanh Tung
 */
public class ViewMyReservationController extends HttpServlet {

    /**
     * -Use function getReservationByDoctorId in
     * <code>dao.impl.ReservationDAOImpl</code> to get an
     * <code>java.util.ArrayList</code> object that contains a series of
     * <code>entity.Reservation</code><br>
     *
     * -Set parameters: dayOfWeek, startWeek, endWeek, viewDay, reservations<br>
     * -Finally forward user to the <code>viewMyReservation.jsp</code> page.
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response is
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null) {
                String viewDay = (request.getParameter("viewDay") != null) ? Utils.parseDateFormat(request.getParameter("viewDay").trim()) : Utils.getToday();
                String startWeek = (request.getParameter("startWeek") != null) ? (request.getParameter("startWeek").trim()) : Utils.getMondayOfThisWeek();
                String endWeek = (request.getParameter("endWeek") != null) ? (request.getParameter("endWeek").trim()) : Utils.getSundayOfThisWeek();
                ReservationDAO reservationDAO = new ReservationDAOImpl();
                ArrayList<Reservation> reservations = reservationDAO.getReservationByDoctorId(user.getUserId(), startWeek, endWeek);
                ArrayList<String> dayOfWeek = Utils.getDayOfThisWeek(viewDay);
                request.setAttribute("dayOfWeek", dayOfWeek);
                request.setAttribute("startWeek", startWeek);
                request.setAttribute("endWeek", endWeek);
                request.setAttribute("viewDay", Utils.revertParseDateFormat(viewDay));
                request.setAttribute("today", viewDay);
                request.setAttribute("reservations", reservations);
                request.getRequestDispatcher("jsp/viewMyReservation.jsp").forward(request, response);
            } else {
                 request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
            }
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
