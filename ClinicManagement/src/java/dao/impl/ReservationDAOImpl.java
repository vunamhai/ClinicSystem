/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.DBContext;
import dao.ReservationDAO;
import entity.Reservation;
import entity.Service;
import entity.ServicePackage;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyen
 */
public class ReservationDAOImpl extends DBContext implements ReservationDAO {


    @Override
    public ArrayList<User> getDoctorsHasReservation(String viewDay, int serviceId) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    @Override
    public ArrayList<Reservation> getReservationsByDay(String viewDay, int serviceId) {
      ArrayList<Reservation> result = new ArrayList<>();
        String sql = "SELECT DISTINCT reservations.reservation_id,\n"
                + "                users.[user_id],\n"
                + "                users.[username],\n"
                + "                users.full_name,\n"
                + "                services.service_id,\n"
                + "                services.service_name,\n"
                + "                reservations.package_id,\n"
                + "                packages.package_title,\n"
                + "                packages.examination_duration,\n"
                + "                doctors.doctor_id,\n"
                + "                doctors.doctor_username,\n"
                + "                doctors.doctor_full_name,\n"
                + "                reservations.request_examination_date,\n"
                + "                reservations.request_examination_time,\n"
                + "                reservations.confirmed_examination_date,\n"
                + "                reservations.confirmed_examination_time, \n"
                + "                reservations.reservation_date,\n"
                + "                reservations.reservation_status,\n"
                + "                reservations.medical_request\n"
                + "FROM reservations\n"
                + "INNER JOIN services ON reservations.service_id = services.service_id\n"
                + "INNER JOIN users ON reservations.customer_id = users.[user_id]\n"
                + "INNER JOIN packages ON reservations.package_id = packages.package_id\n"
                + "INNER JOIN\n"
                + "  (SELECT users.username AS doctor_username,\n"
                + "          users.full_name AS doctor_full_name,\n"
                + "          users.user_id AS doctor_id\n"
                + "   FROM reservations\n"
                + "   LEFT JOIN users ON reservations.confirmed_doctor_id = users.user_id) AS doctors ON reservations.confirmed_doctor_id = doctors.doctor_id\n"
                + "WHERE reservations.confirmed_examination_date = ? \n";

        if (serviceId != -1) {
            sql += " AND reservations.service_id = ? ";
        }

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setString(1, viewDay);
            if (serviceId != -1) {
                ps.setInt(2, serviceId);
            }
            rs = ps.executeQuery();
            /**
             * set attributes for reservation from result set then add its to
             * result list
             */
            while (rs.next()) {
                Reservation reservation = new Reservation();
                User customer = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("full_name"));
                Service service = new Service(rs.getInt("service_id"), rs.getString("service_name"));
                ServicePackage servicePackage = new ServicePackage(rs.getInt("package_id"), rs.getString("package_title"), rs.getString("examination_duration"));
                User doctor = new User(rs.getInt("doctor_id"), rs.getString("doctor_username"), rs.getString("doctor_full_name"));
                reservation.setReservationId(rs.getInt("reservation_id"));
                reservation.setCustomer(customer);
                reservation.setService(service);
                reservation.setServicePackage(servicePackage);
                reservation.setConfirmedDoctor(doctor);
                reservation.setRequestExaminationDate(rs.getDate("request_examination_date"));
                reservation.setRequestExaminationTime(rs.getTime("request_examination_time"));
                reservation.setConfirmedExaminationDate(rs.getDate("confirmed_examination_date"));
                reservation.setConfirmedExaminationTime(rs.getTime("confirmed_examination_time"));
                reservation.setReservationDate(rs.getDate("reservation_date"));
                reservation.setReservationStatus(rs.getString("reservation_status"));
                reservation.setMedicalRequest(rs.getString("medical_request"));
                result.add(reservation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
          try {
              throw ex;
          } catch (SQLException ex1) {
              Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
          }
        } catch (Exception ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return result;
    }
}
