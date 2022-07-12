package dao;

import entity.BookScheduleDTO;
import entity.CustomerReservation;
import entity.Pagination;
import entity.Reservation;
import entity.ReservationDTO;
import entity.User;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is an interface contains methods of Reservation
 *
 * @author uyenc
 */
public interface ReservationDAO {

    /**
     * - Get full information about a reservation (such as customer information,
     * service information, package information, all reservation information)
     *
     * @param viewDay is a <code>java.lang.String</code> object used to get
     * reservation by date
     * @param serviceId is a <code>java.lang.String</code> object used to get
     * reservation by serviceId
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public ArrayList<Reservation> getReservationsByDay(String viewDay, int serviceId) throws SQLException, Exception;

    public ArrayList<User> getDoctorsHasReservation(String viewDay, int serviceId) throws SQLException, Exception;

    public ArrayList<Reservation> getReservationByDoctorId(int doctorId, String startWeek, String endWeek) throws SQLException, Exception;
 
    public Reservation getReservationById(int reservationId) throws SQLException, Exception;

    public int updateReservationStatusById(int reservationId, String reservationStatus) throws SQLException, Exception;

    public int cancelReceiveReservationById(int reservationId, String reservationStatus, String today) throws SQLException, Exception;

    public ArrayList<String> getTimeScheduleByDoctorId(int doctorId, String date) throws SQLException, Exception;

    public int updateReservationDateTimeById(int reservationId, String confirmReservationDate, String confirmReservationTime) throws SQLException, Exception;

    Pagination<CustomerReservation> getAllCustomerReservation(int pageIndex, int pageSize, int id, String status);

    CustomerReservation getCustomerReservationById(int id);

    void bookReservation(ReservationDTO reservation);

    Pagination<BookScheduleDTO> getAllReservation(int pageIndex, int pageSize);

    void confirmReservation(int doctorId, String time, Date date, int id);
    
}
