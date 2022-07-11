
package controller;

import dao.FeedbackDAO;
import dao.impl.FeedbackDAOImpl;
import entity.FeedbackDTO;
import entity.FeedbackReply;
import entity.Pagination;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewFeedbackManagedListController extends HttpServlet {

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
        String page = request.getParameter("page");
        if (page != null) {
            request.getSession().setAttribute("pageIndex", page);
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
        if (request.getSession().getAttribute("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getSession().getAttribute("pageIndex").toString());
        }
        Pagination<FeedbackDTO> feedbacks = feedbackDAO.getAllFeedback(pageIndex, pageSize, "");
        List<FeedbackReply> feedbackReply = feedbackDAO.getAllReply();
        for (FeedbackDTO feedback : feedbacks.getData()) {
            List<String> listFB = new ArrayList<>();
            for (FeedbackReply f : feedbackReply) {
                if (f.getFeedback() == feedback.getFeedbackId()) {
                    listFB.add(f.getContent());
                }
            }
            feedback.setFeedbackReply(listFB);
        }

        request.setAttribute("feedbacks", feedbacks);
        request.getRequestDispatcher("./jsp/feedbackManagement.jsp").forward(request, response);
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
