/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version          AUTHOR           DESCRIPTION
 * 2022-02-08      1.0              HuongHTT         First Implement 
 */
package dao;

import model.Accounts;
import model.Booking;
import model.Doctor;
import model.Feedback;
import model.Role;
import java.util.List;


public interface AccountDAO {

    Accounts login(String username, String password);

    void createAccount(Accounts account);

    public List<Accounts> getAllAccounts();

    public List<Accounts> getAccountsByPage(int page, int size);

    public void addAccounts(Accounts a);

    public void deleteAccounts(int id);

    public void updateAccounts(Accounts a);

    void updatePassword(String username, String password);

    public Accounts getAccountById(int id);

    public Accounts getAccountByUsername(String username);

    public Accounts getAccountByEmail(String email);

    public List<Role> getAllRoles();

    public void deleteBookingDetailsByBookingID(int bookingID);

    public void deleteReplyFeedbackByFeedbackID(int feedbackID);

    public void deleteFeedbacksByBookingID(int bookingID);

    public void deleteBookingsByAccountID(int accountID);

    public void deleteReplyFeedbackByAccountID(int accountID);

    public void deleteBlogsByAccountID(int accountID);

    public void deleteServiceDoctorByAccountID(int accountID);

    public List<Booking> getAllBookingsByAccountID(int accountID);

    public List<Feedback> getAllFeedbacksByBookingID(int bookingID);

    public List<Accounts> searchAccount(String txtSearch);

    List<Doctor> getDoctorByServiceId(int id);

    List<Doctor> getAllDoctor();
}
