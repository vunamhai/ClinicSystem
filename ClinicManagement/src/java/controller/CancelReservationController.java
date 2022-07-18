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
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * -Use function getExamninationByUserId in
 * <code>dao.impl.ReservationDAOImpl</code> to update reservation status of
 * <code>entity.Reservation</code>. And use function insertNewExamination in
 * <code>dao.impl.ExaminationDAOImpl</code> to insert new examination
 *
 * @author Nguyen Thanh Tung
 */
public class CancelReservationController extends HttpServlet {

    /**
     * -Handles the HTTP <code>POST</code> method to get popUp confirm
     *
     * -Set parameters: check<br>
     * -Finally forward user to the <code>viewReservationDetailPopup.jsp</code>
     * page. Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response is
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int reservationId = (request.getParameter("reservationId") != null) ? Integer.parseInt(request.getParameter("reservationId").trim()) : -1;
            request.setAttribute("reservationId", reservationId);
            request.getRequestDispatcher("jsp/components/confirmDialog.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Không thể tải dữ liệu từ cơ sở dữ liệu");
            request.setAttribute("exceptionMessage", e.getMessage());
            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method to cancel reservation
     *
     * -Set parameters: check<br>
     * -Finally forward user to the <code>viewReservationDetailPopup.jsp</code>
     * page. Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods
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
            int reservationId = (request.getParameter("reservationId") != null) ? Integer.parseInt(request.getParameter("reservationId").trim()) : -1;
            String reservationStatus = "Đã hủy";
            ReservationDAO reservationDAO = new ReservationDAOImpl();
            reservationDAO.updateReservationStatusById(reservationId, reservationStatus);
            response.sendRedirect("viewMyReservation");
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Không thể tải dữ liệu từ cơ sở dữ liệu");
            request.setAttribute("exceptionMessage", e.getMessage());
            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
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
