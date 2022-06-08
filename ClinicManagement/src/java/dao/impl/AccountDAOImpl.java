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
}