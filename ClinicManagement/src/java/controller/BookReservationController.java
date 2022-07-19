package controller;

import dao.PackageDAO;
import dao.ReservationDAO;
import dao.ServiceDAO;
import dao.impl.PackageDAOImpl;
import dao.impl.ReservationDAOImpl;
import dao.impl.ServiceDAOImpl;
import entity.ReservationDTO;
import entity.Service;
import entity.ServicePackage;
import entity.User;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookReservationController extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int serviceId = 0;
        int packageId = 0;
        if (request.getParameter("serviceId") != null && request.getParameter("packageId") != null) {
            serviceId = Integer.parseInt(request.getParameter("serviceId").trim());
            packageId = Integer.parseInt(request.getParameter("packageId").trim());
            session.setAttribute("serviceId", serviceId);
            session.setAttribute("packageId", packageId);
        }

        if (request.getParameter("running") == null) {
            PackageDAO packageDAO = new PackageDAOImpl();
            List<ServicePackage> packages = packageDAO.getAllPackage();
            ServiceDAO serviceDAO = new ServiceDAOImpl();
            try {
                ArrayList<Service> services = serviceDAO.getServices();
                request.setAttribute("packages", packages);
                request.setAttribute("services", services);

                request.getRequestDispatcher("./jsp/bookAReservation.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(BookReservationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            User user = (User) session.getAttribute("user");
            if (user == null) {
                request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
                return;
            }

            String date1 = request.getParameter("date");
            format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
            java.util.Date jdate1 = format.parse(date1);
            java.sql.Date sdate1 = new java.sql.Date(jdate1.getTime());

            String time = request.getParameter("time");

            String reqeust = request.getParameter("request");

            ReservationDTO reservation = new ReservationDTO();
            reservation.setCustomerRequest(reqeust);
            reservation.setRequestDate(sdate1);
            reservation.setId(user.getUserId());
            reservation.setPackageId((int) session.getAttribute("packageId"));
            reservation.setServiceId((int) session.getAttribute("serviceId"));

            ReservationDAO reservationDAO = new ReservationDAOImpl();
            reservationDAO.bookReservation(reservation);
            ViewCustomerReservationsList controller = new ViewCustomerReservationsList();
            controller.processRequest(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(BookReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(BookReservationController.class.getName()).log(Level.SEVERE, null, ex);
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
