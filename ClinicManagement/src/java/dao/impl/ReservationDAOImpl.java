/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.DBContext;
import dao.ReservationDAO;
import entity.BookScheduleDTO;
import entity.CustomerReservation;
import entity.Pagination;
import entity.Reservation;
import entity.Service;
import entity.ServicePackage;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public Pagination<CustomerReservation> getAllCustomerReservation(int pageIndex, int pageSize, int id, String status) {
         Pagination<CustomerReservation> pagination = new Pagination<>();
        List<CustomerReservation> customerReservations = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT DISTINCT ROW_NUMBER() OVER ( ORDER BY r.confirmed_examination_date )\n"
                + "                    AS RowNum, r.reservation_id,  p.examination_duration, p.package_title, p.price, s.service_id, s.service_name, r.reservation_status, r.medical_request, r.request_examination_date, r.confirmed_examination_date from reservations r join services s\n"
                + "  on r.service_id = s.service_id and r.reservation_status like N" + "'%" + status + "%'" + "\n"
                + "  join packages p\n"
                + "  on r.package_id = p.package_id and r.customer_id = ?) \n"
                + "                    AS RowConstrainedResult\n"
                + "                    WHERE   RowNum >= ?\n"
                + "                  AND RowNum <= ?\n"
                + "                    ORDER BY RowNum";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, (pageIndex - 1) * pageSize);
            ps.setInt(3, (pageIndex - 1) * pageSize + pageSize);
            rs = ps.executeQuery();
            /**
             * set attributes for doctors from result set then add its to result
             * list
             */
            int totalItem = count(id, status); // count total service
            pagination.setCurrentPage(pageIndex);
            pagination.setItemPerPage(pageSize);
            pagination.setTotalItem(totalItem);
            while (rs.next()) {
                CustomerReservation reservation = new CustomerReservation();
                reservation.setId(rs.getInt("reservation_id"));
                reservation.setServiceId(rs.getInt("service_id"));
                reservation.setExaminationDuration(rs.getString("examination_duration"));
                reservation.setPackageTitle(rs.getString("package_title"));
                reservation.setPrice(rs.getFloat("price"));
                reservation.setServiceName(rs.getString("service_name"));
                reservation.setReservationStatus(rs.getString("reservation_status"));
                reservation.setMedicalRequest(rs.getString("medical_request"));
                reservation.setRequestExaminationDate(rs.getDate("request_examination_date"));
                reservation.setConfirmedExaminationDate(rs.getDate("confirmed_examination_date"));
                customerReservations.add(reservation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            /**
             * close result set, prepared statement and connection by
             * corresponding order
             */
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        pagination.setData(customerReservations);
        return pagination;
    }

    private int count(int id, String status) {
        Connection connecion = null;
        PreparedStatement countPreparedStatement = null;
        ResultSet countResultSet = null;
        try {
            connecion = getConnection();
            String sql = "";
            if (id > 0) {
                sql = "SELECT COUNT(*) FROM (\n"
                        + " select DISTINCT r.reservation_id, p.examination_duration, p.package_title, p.price, s.service_name, r.reservation_status, r.medical_request, r.request_examination_date, r.confirmed_examination_date from reservations r join services s\n"
                        + "  on r.service_id = s.service_id\n"
                        + "  join packages p\n"
                        + "  on r.package_id = p.package_id and r.customer_id = ? and r.reservation_status like N" + "'%" + status + "%'\n"
                        + ") AS derived;";
            } else {
                sql = "SELECT COUNT(*) FROM (\n"
                        + " select DISTINCT r.reservation_id, p.examination_duration, p.package_title, p.price, s.service_name, r.reservation_status, r.medical_request, r.request_examination_date, r.confirmed_examination_date from reservations r join services s\n"
                        + "  on r.service_id = s.service_id\n"
                        + "  join packages p\n"
                        + "  on r.package_id = p.package_id and r.reservation_status like N" + "'%" + status + "%'\n"
                        + ") AS derived;";
            }
            countPreparedStatement = connecion.prepareStatement(sql);
            if (id > 0) {
                countPreparedStatement.setInt(1, id);
            }
            countResultSet = countPreparedStatement.executeQuery();
            if (countResultSet.next()) {
                // get and return count total services
                return countResultSet.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(countResultSet);
            closePreparedStatement(countPreparedStatement);
            closeConnection(connecion);
        }
        return 0;
    }

    @Override
    public Pagination<BookScheduleDTO> getAllReservation(int pageIndex, int pageSize) {
       Pagination<BookScheduleDTO> pagination = new Pagination<>();
        List<BookScheduleDTO> bookScheduleDTOs = new ArrayList<>();
        String sql = "SELECT *\n"
                + "                    FROM (SELECT ROW_NUMBER() OVER ( ORDER BY full_name )\n"
                + "                    AS RowNum, u.full_name, s.service_name, p.package_title, r.reservation_id, r.request_examination_date, r.reservation_date, r.medical_request, r.reservation_status from reservations r\n"
                + "				  join users u\n"
                + "				  on r.customer_id = u.user_id\n"
                + "				  join services s\n"
                + "				  on r.service_id = s.service_id\n"
                + "				  join packages p\n"
                + "				  on r.package_id = p.package_id\n"
                + "				  where r.reservation_status = N'Chờ duyệt') \n"
                + "                    AS RowConstrainedResult\n"
                + "                    WHERE   RowNum >= ?\n"
                + "                        AND RowNum <= ?\n"
                + "                    ORDER BY RowNum";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setInt(1, (pageIndex - 1) * pageSize);
            ps.setInt(2, (pageIndex - 1) * pageSize + pageSize);
            rs = ps.executeQuery();
            /**
             * set attributes for doctors from result set then add its to result
             * list
             */
            int totalItem = countReservation();
            pagination.setCurrentPage(pageIndex);
            pagination.setItemPerPage(pageSize);
            pagination.setTotalItem(totalItem);
            while (rs.next()) {
                BookScheduleDTO reservation = new BookScheduleDTO();
                reservation.setReservationId(rs.getInt("reservation_id"));
                reservation.setPatientName(rs.getString("full_name"));
                reservation.setService(rs.getString("service_name"));
                reservation.setPackageService(rs.getString("package_title"));
                reservation.setRequestDate(rs.getDate("request_examination_date"));
                reservation.setConfirmDate(rs.getDate("reservation_date"));
                reservation.setMedicalRequest(rs.getString("medical_request"));
                reservation.setStatus(rs.getString("reservation_status"));
                bookScheduleDTOs.add(reservation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            /**
             * close result set, prepared statement and connection by
             * corresponding order
             */
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        pagination.setData(bookScheduleDTOs);
        return pagination;
    }

    private int countReservation() {
      Connection connecion = null;
        PreparedStatement countPreparedStatement = null;
        ResultSet countResultSet = null;
        try {
            connecion = getConnection();
            String sql = "select COUNT(*) from reservations  where reservation_status = N'Chờ duyệt'";
            countPreparedStatement = connecion.prepareStatement(sql);

            countResultSet = countPreparedStatement.executeQuery();
            if (countResultSet.next()) {
                // get and return count total services
                return countResultSet.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(countResultSet);
            closePreparedStatement(countPreparedStatement);
            closeConnection(connecion);
        }
        return 0;
    }
}
