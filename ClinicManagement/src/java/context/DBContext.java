/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 tungnt           First Implement 
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Thanh Tung
 */
public class DBContext {

   
    private Connection connection;

    /**
     * Create a connection to database
     *
     * @return connection Is a connection connect to database. It's a
     * <code>java.sql.Connection</code> object
     * @throws Exception
     */
    public Connection getConnection() {
        try {
            //Change the username password and url to connect your own database
            String username = "sa";
            String password = "12345678";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=ClinicManagement";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }


    /**
     * Close a connection from database
     *
     * @param connection Is a connection connect to database. It's a
     * <code>java.sql.Connection</code> object
     */
    protected void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Close a result set from a connection
     *
     * @param rs Is a result set from a connection. It's a
     * <code>java.sql.ResultSet</code> object
     */
    protected void closeResultSet(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Close a prepared statement from a connection
     *
     * @param st Is a prepared statement from a connection. It's a
     * <code>java.sql.PreparedStatement</code> object
     */
    protected void closePreparedStatement(PreparedStatement st) {
        try {
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
