
package dao.impl;

import context.DBContext;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.AccountDAO;
import entity.Account1;
import entity.Accounts;
import entity.Booking;
import entity.Feedback;
import entity.Role;
import entity.SQLCommands;
import java.sql.SQLException;

/**
 *
 * @author Nguyen Van Nam
 */
public class AccountDAOImpl extends DBContext implements AccountDAO {

    /**
     * Logger for system
     */
    private static Logger logger = Logger.getLogger(AccountDAOImpl.class.getName());

    /*
    * Get all user from database. 
    * 
    * @return a list of <code>User</code> objects. It is
    * a <code>java.util.List</code> object 
     */
    @Override
    public Account1 login(String username, String password) {
        logger.log(Level.INFO, "Login Controller");
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("select a.ID , a.UserName, a.Password, r.role_id from Accounts a join Account_Roles r on a.role_id = r.role_id where UserName = ? "
                    + "and BINARY_CHECKSUM(Password) = BINARY_CHECKSUM(?)");
            preparedStatement.setNString(1, username);
            preparedStatement.setNString(2, password);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Account1 user = new Account1();
                user.setRole_id(rs.getInt("role_id"));
                user.setUsername(username);
                user.setPassword(password);
                return user;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return null;
    }
     @Override
    public void createAccount(Account account) {
        logger.log(Level.INFO, "Create account");
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("insert into Accounts ([FirstName]\n" +
"           ,[LastName]\n" +
"           ,[DoB]\n" +
"           ,[Gender]\n" +
"           ,[Phone]\n" +
"           ,[UserName]\n" +
"           ,[Email]\n" +
"           ,[Password]\n" +
"           ,[Street]\n" +
"           ,[City]\n" +
"           ,[Country])\n"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, account.getFirstname());
            preparedStatement.setString(2, account.getLastname());
             preparedStatement.setDate(3, account.getDob());
            if (account.isGender()) {
                preparedStatement.setInt(4, 1);
            } else {
                preparedStatement.setInt(4, 0);
            }
             preparedStatement.setString(5, account.getPhone());
            preparedStatement.setString(6, account.getUsername());
            preparedStatement.setString(7, account.getEmail());
            preparedStatement.setString(8, account.getPassword());
            preparedStatement.setString(9, account.getStreet());
            preparedStatement.setString(10, account.getCity());
            preparedStatement.setString(10, account.getCity());
            preparedStatement.setString(11, account.getCountry());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }


    /*
    * Get all accounts from database. 
    * 
    * @return a list of <code>Account</code> objects. It is
    * a <code>java.util.List</code> object 
     */

    @Override
    public List<Accounts> getAllAccounts() {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        ResultSet rs = null;
        try {
            List<Accounts> accountsList= new ArrayList<>();
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.GET_ALL_ACCOUNTS);
            rs=pre.executeQuery();
            while(rs.next()){
                Accounts a=new Accounts();
                a.setId(rs.getInt("ID"));
                a.setEmail(rs.getString("Email"));
                a.setFirstname(rs.getString("FirstName"));
                a.setLastname(rs.getString("LastName"));
                a.setDob(rs.getDate("DoB"));
                a.setGender(rs.getBoolean("Gender"));
                a.setPhone(rs.getString("Phone"));
                a.setUsername(rs.getString("UserName"));
                a.setStreet(rs.getString("Street"));
                a.setCity(rs.getString("City"));
                a.setCountry(rs.getString("Country"));
                accountsList.add(a);
            }
            return accountsList;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    @Override
    public void addAccounts(Accounts a) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.ADD_ACCOUNT);
            pre.setString(1, a.getUsername());
            pre.setString(2, a.getFirstname());
            pre.setString(3, a.getLastname());
            pre.setString(4, a.getEmail());
            pre.setString(5, a.getStreet());
            pre.setString(6, a.getCity());
            pre.setString(7, a.getCountry());
            pre.setString(8, a.getPhone());
            pre.setDate(9, a.getDob());
            pre.setBoolean(10, a.isGender());
            pre.setString(11, a.getPassword());
            pre.setInt(12, a.getRoleID());
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deleteAccounts(int id) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.DELETE_ACCOUNTS_BY_ID);
            pre.setInt(1, id);
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void updateAccounts(Accounts a) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.UPDATE_ACCOUNT_BY_ID);
            pre.setString(1, a.getUsername());
            pre.setString(2, a.getFirstname());
            pre.setString(3, a.getLastname());
            pre.setString(4, a.getEmail());
            pre.setString(5, a.getStreet());
            pre.setString(6, a.getCity());
            pre.setString(7, a.getCountry());
            pre.setString(8, a.getPhone());
            pre.setDate(9, a.getDob());
            pre.setBoolean(10, a.isGender());
            pre.setInt(11, a.getRoleID());
            pre.setInt(12, a.getId());
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Accounts getAccountById(int id) {
       DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        ResultSet rs = null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.GET_ACCOUNT_BY_ID);
            pre.setInt(1, id);
            rs=pre.executeQuery();
            if(rs.next()){
                Accounts a=new Accounts();
                a.setId(rs.getInt("ID"));
                a.setEmail(rs.getString("Email"));
                a.setFirstname(rs.getString("FirstName"));
                a.setLastname(rs.getString("LastName"));
                a.setDob(rs.getDate("DoB"));
                a.setGender(rs.getBoolean("Gender"));
                a.setPhone(rs.getString("Phone"));
                a.setUsername(rs.getString("UserName"));
                a.setPassword(rs.getString("Password"));
                a.setStreet(rs.getString("Street"));
                a.setCity(rs.getString("City"));
                a.setCountry(rs.getString("Country"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    @Override
    public Accounts getAccountByUsername(String username) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        ResultSet rs = null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.GET_ACCOUNT_BY_USERNAME);
            pre.setString(1, username);
            rs=pre.executeQuery();
            if(rs.next()){
                Accounts a=new Accounts();
                a.setId(rs.getInt("ID"));
                a.setEmail(rs.getString("Email"));
                a.setFirstname(rs.getString("FirstName"));
                a.setLastname(rs.getString("LastName"));
                a.setDob(rs.getDate("DoB"));
                a.setGender(rs.getBoolean("Gender"));
                a.setPhone(rs.getString("Phone"));
                a.setUsername(rs.getString("UserName"));
                a.setStreet(rs.getString("Street"));
                a.setCity(rs.getString("City"));
                a.setCountry(rs.getString("Country"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    @Override
    public Accounts getAccountByEmail(String email) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        ResultSet rs = null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.GET_ACCOUNT_BY_EMAIL);
            pre.setString(1, email);
            rs=pre.executeQuery();
            if(rs.next()){
                Accounts a=new Accounts();
                a.setId(rs.getInt("ID"));
                a.setFirstname(rs.getString("FirstName"));
                a.setLastname(rs.getString("LastName"));
                a.setDob(rs.getDate("DoB"));
                a.setGender(rs.getBoolean("Gender"));
                a.setPhone(rs.getString("Phone"));
                a.setUsername(rs.getString("UserName"));
                a.setEmail(rs.getString("Email"));
                a.setPassword("Password");
                a.setStreet(rs.getString("Street"));
                a.setCity(rs.getString("City"));
                a.setCountry(rs.getString("Country"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    @Override
    public void updatePassword(String username, String password) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("UPDATE [dbo].[Accounts]\n"
                    + "   SET \n"
                    + "      [Password] = ?\n"
                    + "      \n"
                    + " WHERE UserName = ?");

            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);

            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }

    public int updatePasswordById(int id, String pass) {
       DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.UPDATE_PASSWORD_BY_ID);
            pre.setString(1, pass);
            pre.setInt(2, id);
            return pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

    @Override
    public List<Accounts> getAccountsByPage(int page, int size) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        ResultSet rs = null;
        try {
            List<Accounts> accountsList= new ArrayList<>();
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.GET_ALL_ACCOUNTS_BY_PAGE);
            pre.setInt(1, page);
            pre.setInt(2, size);
            pre.setInt(3, size);
            pre.setInt(4, page);
            pre.setInt(5, size);
            rs=pre.executeQuery();
            while(rs.next()){
                Accounts a=new Accounts();
                a.setId(rs.getInt("ID"));
                a.setEmail(rs.getString("Email"));
                a.setFirstname(rs.getString("FirstName"));
                a.setLastname(rs.getString("LastName"));
                a.setDob(rs.getDate("DoB"));
                a.setGender(rs.getBoolean("Gender"));
                a.setPhone(rs.getString("Phone"));
                a.setUsername(rs.getString("UserName"));
                a.setStreet(rs.getString("Street"));
                a.setCity(rs.getString("City"));
                a.setCountry(rs.getString("Country"));
                a.setRoleID(rs.getInt("role_id"));
                a.setRoleName(rs.getString("role_name"));
                accountsList.add(a);
            }
            return accountsList;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        ResultSet rs = null;
        try {
            List<Role> roleList= new ArrayList<>();
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.GET_ALL_ROLES);
            rs=pre.executeQuery();
            while(rs.next()){
                Role role=new Role();
                role.setRoleId(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));
                roleList.add(role);
            }
            return roleList;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    @Override
    public void deleteBookingDetailsByBookingID(int bookingID) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.DELETE_BOOKING_DETAILS_BY_BOOKING_ID);
            pre.setInt(1, bookingID);
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deleteReplyFeedbackByFeedbackID(int feedbackID) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.DELETE_REPLY_FEEDBACK_BY_FEEDBACK_ID);
            pre.setInt(1, feedbackID);
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deleteFeedbacksByBookingID(int bookingID) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.DELETE_FEEDBACKS_BY_BOOKING_ID);
            pre.setInt(1, bookingID);
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deleteBookingsByAccountID(int accountID) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.DELETE_BOOKINGS_BY_ACCOUNT_ID);
            pre.setInt(1, accountID);
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deleteReplyFeedbackByAccountID(int accountID) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.DELETE_REPLY_FEEDBACK_BY_ACCOUNT_ID);
            pre.setInt(1, accountID);
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deleteBlogsByAccountID(int accountID) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.DELETE_BLOGS_BY_ACCOUNT_ID);
            pre.setInt(1, accountID);
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deleteServiceDoctorByAccountID(int accountID) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        try {
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.DELETE_SERVICE_DOCTOR_BY_ACCOUNT_ID);
            pre.setInt(1, accountID);
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Booking> getAllBookingsByAccountID(int accountID) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        ResultSet rs = null;
        try {
            List<Booking> bookingList= new ArrayList<>();
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.GET_ALL_BOOKINGS_BY_ACCOUNT_ID);
            pre.setInt(1, accountID);
            rs=pre.executeQuery();
            while(rs.next()){
                Booking b=new Booking();
                b.setBookingID(rs.getInt("booking_id"));
                b.setServicePackageID(rs.getInt("servicePackage_id"));
                b.setPatientID(rs.getInt("patient_id"));
                b.setBookingStatusID(rs.getInt("bookingStatus_id"));
                bookingList.add(b);
            }
            return bookingList;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    @Override
    public List<Feedback> getAllFeedbacksByBookingID(int bookingID) {
        DBContext db=new DBContext();
        Connection conn= null;
        PreparedStatement pre= null;
        ResultSet rs = null;
        try {
            List<Feedback> feedbackList= new ArrayList<>();
            conn=db.getConnection();
            pre=conn.prepareStatement(SQLCommands.GET_ALL_FEEDBACKS_BY_BOOKING_ID);
            pre.setInt(1, bookingID);
            rs=pre.executeQuery();
            while(rs.next()){
                Feedback f=new Feedback();
                f.setFeedbackID(rs.getInt("feedback_id"));
                f.setBookingID(rs.getInt("booking_id"));
                f.setPatientID(rs.getInt("patient_id"));
                f.setDescription(rs.getString("Description"));
                feedbackList.add(f);
            }
            return feedbackList;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}