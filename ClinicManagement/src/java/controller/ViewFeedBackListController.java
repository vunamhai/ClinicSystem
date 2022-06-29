/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-03-08     1.0                 TrangCT          Controller View Feedback List
 */
package controller;

import dao.FeedbackDAO;
import dao.ServiceDAO;
import dao.impl.FeedbackDAOImpl;
import dao.impl.ServiceDAOImpl;
import entity.FeedbackDTO;
import entity.Feedback;
import entity.Pagination;
import entity.ServiceDTO;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <h1>View Feedback List Controller </h1>
 * Controller to view feedback list. Method process data form ReservationDAO and
 * forward data to file view
 * <p>
 *
 *
 * @author TrangCT
 * @version 1.0
 * @since 2022-03-08
 */
public class ViewFeedBackListController extends HttpServlet {

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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
            return;
        }
        String page = request.getParameter("page");
        int service = 0;
        if (request.getParameter("serviceId") != null) {
            service = Integer.parseInt(request.getParameter("serviceId"));
        }

        String time = request.getParameter("time");
        if (time == null) {
            time = "";
        }

        int pageIndex = 1;
        if (page != null) {
            try {
                pageIndex = Integer.parseInt(page);
                if (pageIndex == -1) {
                    pageIndex = 1;
                }
            } catch (Exception e) {
                pageIndex = 1;
            }
        } else {
            pageIndex = 1;
        }

        int pageSize = 5;

        FeedbackDAO feedbackDAO = new FeedbackDAOImpl();
        ServiceDAO serviceDAO = new ServiceDAOImpl();
        Pagination<FeedbackDTO> feedbacks;
        int userId = user.getUserId();
        if (service != 0) {
            feedbacks = feedbackDAO.getAllCustomerFeedback(pageIndex, pageSize, service, time, userId);
        } else {
            feedbacks = feedbackDAO.getAllCustomerFeedback(pageIndex, pageSize, time, userId);
        }

        List<Date> times = feedbackDAO.getAllDate();

        Pagination<ServiceDTO> services
                = serviceDAO.getAllService(1, 50);
        request.setAttribute("times", times);
        request.setAttribute("services", services);
        request.setAttribute("feedbacks", feedbacks);
        request.getRequestDispatcher("./jsp/feedback.jsp").forward(request, response);

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
