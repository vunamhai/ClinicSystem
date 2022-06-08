/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version          AUTHOR           DESCRIPTION
 * 2022-02-08      1.0              HuongHTT         First Implement 
 */
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
            preparedStatement = connecion.prepareStatement("select a.ID , a.UserName, a.Password, r.role_id from Accounts a join Account_Roles r on a.ID = r.ID where UserName = ? "
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            pre.setInt(11, a.getId());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}