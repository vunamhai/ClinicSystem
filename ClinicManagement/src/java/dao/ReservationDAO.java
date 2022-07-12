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

    /**
     * - Get doctor information about a reservation (such as doctorId,
     * doctorUserName, doctorFullName)
     *
     * @param viewDay is a <code>java.lang.String</code> object used to get
     * reservation by date
     * @param serviceId is a <code>java.lang.String</code> object used to get
     * reservation by serviceId
     * @return a list of <code>User</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public ArrayList<User> getDoctorsHasReservation(String viewDay, int serviceId) throws SQLException, Exception;

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
    public ArrayList<Reservation> getReservationByDoctorId(int doctorId, String startWeek, String endWeek) throws SQLException, Exception;

    /**
     * - Get reservation information by reservation id
     *
     * @param reservationId is a <code>java.lang.int</code> object used to get
     * reservation by reservationId
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public Reservation getReservationById(int reservationId) throws SQLException, Exception;

    /**
     * - Update reservation status
     *
     * @param reservationId is a <code>java.lang.int</code> object used to
     * update reservation by reservationId
     * @param reservationStatus is a <code>java.lang.String</code> object used
     * to update reservation by reservationStatus
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public int updateReservationStatusById(int reservationId, String reservationStatus) throws SQLException, Exception;

    /**
     * - Update reservation status to unconfirmed
     *
     * @param reservationId is a <code>java.lang.int</code> object used to
     * update reservation by reservationId
     * @param reservationStatus is a <code>java.lang.String</code> object used
     * to update reservation by reservationStatus
     * @param today is a <code>java.lang.String</code> object used to update
     * reservation by reservationStatus
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public int cancelReceiveReservationById(int reservationId, String reservationStatus, String today) throws SQLException, Exception;

    /**
     * - Get Time Schedule By Doctor Id
     *
     * @param doctorId is a <code>java.lang.int</code> object used to Get Time
     * Schedule By Doctor Id by reservationId
     * @param date is a <code>java.lang.String</code> object used to Get Time
     * Schedule By Doctor Id by reservationStatus
     * @return a list of <code>String</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public ArrayList<String> getTimeScheduleByDoctorId(int doctorId, String date) throws SQLException, Exception;

    /**
     * - Update reservation date, reservation time
     *
     * @param reservationId is a <code>java.lang.int</code> object used to
     * update reservation by new reservation date, time
     * @param confirmReservationDate is a <code>java.lang.String</code> object
     * used to update reservation reservation by new reservation date, time
     * @param confirmReservationTime is a <code>java.lang.String</code> object
     * used to update reservation by reservation by new reservation date, time
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public int updateReservationDateTimeById(int reservationId, String confirmReservationDate, String confirmReservationTime) throws SQLException, Exception;

    Pagination<CustomerReservation> getAllCustomerReservation(int pageIndex, int pageSize, int id, String status);

    CustomerReservation getCustomerReservationById(int id);

    void bookReservation(ReservationDTO reservation);

    Pagination<BookScheduleDTO> getAllReservation(int pageIndex, int pageSize);

    void confirmReservation(int doctorId, String time, Date date, int id);
    
}
