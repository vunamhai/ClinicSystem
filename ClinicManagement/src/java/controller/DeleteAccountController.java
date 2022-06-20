/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.AccountDAOImpl;
import entity.Booking;
import entity.Feedback;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nam Ngo
 */
public class DeleteAccountController extends HttpServlet {

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
        int accountID= Integer.parseInt(request.getParameter("id"));
        AccountDAOImpl ad=new AccountDAOImpl();
        List<Booking> bookingList=ad.getAllBookingsByAccountID(accountID);
        if(bookingList!=null){
            for(Booking b: bookingList){
                List<Feedback> feedbackList=ad.getAllFeedbacksByBookingID(b.getBookingID());
                if(feedbackList!=null){
                    for(Feedback f: feedbackList){
                        ad.deleteReplyFeedbackByFeedbackID(f.getFeedbackID());
                    }
                }
                ad.deleteFeedbacksByBookingID(b.getBookingID());
            }
        }
        ad.deleteBookingsByAccountID(accountID);
        ad.deleteReplyFeedbackByAccountID(accountID);
        ad.deleteBlogsByAccountID(accountID);
        ad.deleteServiceDoctorByAccountID(accountID);
        ad.deleteAccounts(accountID);
        String txtSearch= request.getParameter("txtSearch");
        if(txtSearch.isEmpty()){
            int page= Integer.parseInt(request.getParameter("page"));
            response.sendRedirect("ViewAllAccountController?page="+page);
        }
        else{
            response.sendRedirect("SearchAccountController?search="+txtSearch);
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
