/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.BookScheduleDTO;
import entity.CustomerReservation;
import entity.Pagination;
import entity.Reservation;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nguyen
 */
public interface ReservationDAO {
     public ArrayList<User> getDoctorsHasReservation(String viewDay, int serviceId) throws SQLException, Exception;

    public ArrayList<Reservation> getReservationsByDay(String viewDay, int serviceId);

    public Pagination<CustomerReservation> getAllCustomerReservation(int pageIndex, int pageSize, int userId, String status);

    public Pagination<BookScheduleDTO> getAllReservation(int pageIndex, int pageSize);

    /**
     * - Get reservation information by doctor id
     *
     * @param doctorId is a <code>java.lang.int</code> object used to get
     * reservation by doctorId
     * @param startWeek is a <code>java.lang.String</code> object used to get
     * reservation has confirmed reservation date greater startWeek
     * @param endWeek is a <code>java.lang.String</code> object used to get
     * reservation has confirmed reservation date lesser startWeek
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
}
