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

import dao.ExaminationDAO;
import dao.ReservationDAO;
import dao.impl.ExaminationDAOImpl;
import dao.impl.ReservationDAOImpl;
import entity.Examination;
import entity.Reservation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * -This class uses function getExamninationByUserId in
 * <code>dao.impl.ExaminationDAOImpl</code> to get list of
 * <code>entity.Examination</code>. It's a <code>java.util.ArrayList</code>
 * object
 *
 * @author Nguyen Thanh Tung
 */
public class AddNewExaminationController extends HttpServlet {

    /**
     * -Use function getExamninationByUserId in
     * <code>dao.impl.ExaminationDAOImpl</code> to get list of
     * <code>entity.Examination</code>. It's a <code>java.util.ArrayList</code>
     * object
     *
     * -Set parameters: examination<br>
     * -Finally forward user to the <code>viewReservationDetailPopup.jsp</code>
     * page. Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response is
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int reservationId = (request.getParameter("reservationId") != null) ? Integer.parseInt(request.getParameter("reservationId").trim()) : -1;
            String examinationDisgosis = (request.getParameter("examinationDisgosis") != null) ? request.getParameter("examinationDisgosis").trim() : "";
            String examinationPrescription = (request.getParameter("examinationPrescription") != null) ? request.getParameter("examinationPrescription").trim() : "";
            String reservationStatus = "Đã khám";
            int check = 0;
            ReservationDAO reservationDAO = new ReservationDAOImpl();
            check = reservationDAO.updateReservationStatusById(reservationId,reservationStatus);
            Reservation reservation = reservationDAO.getReservationById(reservationId);
            ExaminationDAO examinationDAO = new ExaminationDAOImpl();
            check = examinationDAO.insertNewExamination(reservation.getReservationId(), reservation.getConfirmedDoctor().getUserId(), examinationDisgosis, examinationPrescription, reservation.getConfirmedExaminationDate());
            request.setAttribute("check", check);
            request.getRequestDispatcher("viewMyReservation").forward(request, response);
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
