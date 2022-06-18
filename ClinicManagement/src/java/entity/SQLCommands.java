/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Nam Ngo
 */
public class SQLCommands {
    public static String GET_ALL_ACCOUNTS="select * from Accounts";
    public static String GET_ALL_ROLES="select * from Account_Roles";
    public static String GET_ACCOUNT_BY_ID="select * from Accounts where ID= ?";
    public static String GET_ACCOUNT_BY_EMAIL="select * from Accounts where Email= ?";
    public static String GET_ACCOUNT_BY_USERNAME="select * from Accounts where UserName= ?";
    public static String UPDATE_ACCOUNT_BY_ID="update Accounts set UserName=?, FirstName=?, LastName=?, Email=?, Street=?, City=?, Country=?, Phone=?, DoB=?, Gender=?, role_id=? where ID=?";
    public static String ADD_ACCOUNT="insert into Accounts(UserName,FirstName,LastName,Email,Street,City,Country,Phone,DoB,Gender,[Password],role_id) values (?,?,?,?,?,?,?,?,?,?,?,?)";
    public static String UPDATE_PASSWORD_BY_ID="update Accounts set [Password]=? where ID=?";
    public static String GET_ALL_ACCOUNTS_BY_PAGE="with Acc as (select ROW_NUMBER() over (order by ID asc) as RowNum,a.ID,a.role_id,ar.role_name,a.FirstName,a.LastName,a.DoB,a.Gender,a.Phone,a.UserName,a.Email,a.[Password],a.Street,a.City,a.Country from Accounts a, Account_Roles ar where a.role_id=ar.role_id)\n" +
                                                    "select * from Acc where RowNum between ?*?-(?-1) and ?*?";
    public static String DELETE_BOOKING_DETAILS_BY_BOOKING_ID="delete Booking_Details where booking_id= ?";
    public static String DELETE_REPLY_FEEDBACK_BY_FEEDBACK_ID="delete Reply_Feedback where feedback_id= ?";
    public static String DELETE_FEEDBACKS_BY_BOOKING_ID="delete Feedbacks where booking_id= ?";
    public static String DELETE_BOOKINGS_BY_ACCOUNT_ID="delete Bookings where patient_id= ?";
    public static String DELETE_REPLY_FEEDBACK_BY_ACCOUNT_ID="delete Reply_Feedback where doctor_id= ?";
    public static String DELETE_BLOGS_BY_ACCOUNT_ID="delete Blogs where account_id= ?";
    public static String DELETE_SERVICE_DOCTOR_BY_ACCOUNT_ID="delete Service_Doctors where doctor_id= ?";
    public static String GET_ALL_BOOKINGS_BY_ACCOUNT_ID="select * from Bookings where patient_id= ?";
    public static String GET_ALL_FEEDBACKS_BY_BOOKING_ID="select * from Feedbacks where booking_id= ?";
    public static String DELETE_ACCOUNTS_BY_ID="delete Accounts where ID= ?";
}
