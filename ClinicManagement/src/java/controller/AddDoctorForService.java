
package controller;


import dao.AccountDAO;
import dao.impl.AccountDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * -This class uses function addDoctorForService in
 * <code>dao.impl.UserDAOImpl</code> to get list of
 * <code>entity.User</code>. It's a <code>java.util.ArrayList</code>
 * object
 *
 * @author nguyen
 */

public class AddDoctorForService extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int doctor = Integer.parseInt(request.getParameter("doctor"));
        int service = Integer.parseInt(request.getParameter("service"));
        
        AccountDAOImpl userDAO = new AccountDAOImpl();
        userDAO.addDoctorForService(doctor, service);
        ServiceManagementList controller = new ServiceManagementList();
        controller.processRequest(request, response);
        
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
