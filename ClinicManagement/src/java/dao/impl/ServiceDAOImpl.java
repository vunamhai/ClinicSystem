/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-05-26      1.0                 UYENNP          Service DAO Implement
 */
package dao.impl;

import context.DBContext;
import dao.ServiceDAO;
import model.Pagination;
import model.Service;
import model.ServiceDTO;
import model.ViewServiceX;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>Service DAO</h1>
 * Data access object connect database and access data. - count : count list
 * services - getAllService : get list services by paging - getById : get
 * service by id
 * <p>
 *
 *
 * @author UYENNP
 * @version 1.0
 * @since 2022-05-26
 */
public class ServiceDAOImpl extends DBContext implements ServiceDAO {

    /**
     * Logger for system
     */
//    private static Logger logger = Logger.getLogger(UserDAOImpl.class.getName());
    /**
     * Method: Get All Service
     *
     * - get all services by pageIndex and pageSize
     *
     * @param pageIndex integer
     * @param pageSize integer
     * @return pagination Pagination Service
     */
//    public Pagination<ServiceDTO> getAllService(int pageIndex, int pageSize) {
//
//        Pagination<ServiceDTO> pagination = new Pagination<>(); // pagination services
//
//        logger.log(Level.INFO, "getAllService");
//        Connection connecion = null; // connection database
//        PreparedStatement preparedStatement = null;
//        ResultSet rs = null;
//        List<ServiceDTO> services = new ArrayList<>();// list all services
//        try {
//            int totalItem = count(); // count total service
//            pagination.setCurrentPage(pageIndex);
//            pagination.setItemPerPage(pageSize);
//            pagination.setTotalItem(totalItem);
//
//            connecion = getConnection();
//            // Get data
//            preparedStatement = connecion.prepareStatement(""
//                    + "SELECT  *\n"
//                    + "FROM (SELECT ROW_NUMBER() OVER ( ORDER BY service_id )\n"
//                    + "AS RowNum, * FROM  services) \n"
//                    + "AS RowConstrainedResult\n"
//                    + "WHERE   RowNum >= ?\n"
//                    + "    AND RowNum <= ?\n"
//                    + "ORDER BY RowNum");
//            preparedStatement.setInt(1, (pageIndex - 1) * pageSize);
//            preparedStatement.setInt(2, (pageIndex - 1) * pageSize + pageSize);
//            //excute query
//            rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                ServiceDTO service = new ServiceDTO();
//                service.setServiceId(rs.getInt("service_id"));
//                service.setServiceName(rs.getString("service_name"));
//                service.setServiceBrief(rs.getString("service_brief"));
//                service.setServiceDescription(rs.getString("service_description"));
//                service.setServiceImage(rs.getString("service_image"));
//                services.add(service);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            closeResultSet(rs);
//            closePreparedStatement(preparedStatement);
//            closeConnection(connecion);
//        }
//        pagination.setData(services);// paging for list services
//        return pagination;
//    }
    /**
     * Method : count - count total services in database
     *
     * @return an integer
     */
    public int count() {
        Connection connecion = null;
        PreparedStatement countPreparedStatement = null;
        ResultSet countResultSet = null;
        try {
            connecion = getConnection();
            countPreparedStatement = connecion.prepareStatement("SELECT COUNT(service_id) AS id FROM services;");
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

    /**
     * Method: Get Service By Id - Get and return data of service by an id
     *
     * @param id
     * @return service Service
     */
    public Service getById(int id) {
//        logger.log(Level.INFO, "getById");
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Service service = new Service();
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("select * from Services where service_id = ?");
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                service.setServiceId(rs.getInt("service_id"));
                service.setServiceName(rs.getString("service_name"));
                service.setServiceDescription(rs.getString("Description"));
            }
        } catch (Exception ex) {
//            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return service;
    }

    /**
     * - Get all services of clinic
     *
     * @return a list of <code>Service</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException
     */
    @Override
    public ArrayList<Service> getServices() {
        ArrayList<Service> result = new ArrayList<>();
        String sql = "SELECT * FROM [CMS01].[dbo].[services]";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /**
             * set attributes for services from result set then add its to
             * result list
             */
            while (rs.next()) {
                Service service = new Service(rs.getInt("service_id"), rs.getString("service_name"), rs.getString("service_brief"), rs.getString("service_description"),
                                              rs.getString("service_image"), rs.getString("isActive"));
                result.add(service);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
//            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            /**
             * close result set, prepared statement and connection by
             * corresponding order
             */
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return result;

    }
    
    public String getString(String msg) {
        StringBuilder output = new StringBuilder();

        String[] tempStr = msg.trim().split("\\s+");
        for (String string : tempStr) {
            output.append(string).append(" ");
        }
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }

    public ArrayList<Service> searchServices(String search) {
        ArrayList<Service> result = new ArrayList<>();
        String output = getString(search);
        String sql = "SELECT [service_id]\n"
                + "    ,[service_name]\n"
                + " ,[description]\n"
                + "  FROM services where [service_name] like N'%" + output + "%'"
                + "or [service_name] like '%" + output + "%'";
        Connection con = null;
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            /**
             * set attributes for services from result set then add its to
             * result list
             */
            while (rs.next()) {
                Service service = new Service(rs.getInt("service_id"), rs.getString("service_name"), rs.getString("description"));
                result.add(service);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
//            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            /**
             * close result set, prepared statement and connection by
             * corresponding order
             */
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return result;
    }
    
//    public ArrayList<Service> viewServices(int id) throws SQLException {
//        ArrayList<Service> result = new ArrayList<>();
//        String sql = "select s.service_id, s.service_name,Description, firstname, lastname\n"
//                + "from Services s join Accounts acc on s.service_id = acc.service_id\n"
//                + "where s.service_id = ?";
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            con = getConnection(); //get connection
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            rs = ps.executeQuery();
//            /**
//             * set attributes for services from result set then add its to
//             * result list
//             */
//            while (rs.next()) {
//                Service viewService = new Service(rs.getInt("service_id"),
//                        rs.getString("service_name"), rs.getString("description"), rs.getString("firstname"),
//                        rs.getString("lastname"));
//                result.add(viewService);
//            }
//        } catch (SQLException ex) {
////            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//            throw ex;
//        } catch (Exception ex) {
////            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//            /**
//             * close result set, prepared statement and connection by
//             * corresponding order
//             */
//        } finally {
//            this.closeResultSet(rs);
//            this.closePreparedStatement(ps);
//            this.closeConnection(con);
//        }
//        return result;
//    }
    
    public ArrayList<ViewServiceX> viewServices(int id) throws SQLException {
        ArrayList<ViewServiceX> result = new ArrayList<>();
        String sql = "select s.service_id, s.service_name,Description, firstname, lastname\n"
                + "from Services s join Accounts acc on s.service_id = acc.service_id\n"
                + "where s.service_id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            /**
             * set attributes for services from result set then add its to
             * result list
             */
            while (rs.next()) {
                ViewServiceX viewService = new ViewServiceX(rs.getInt("service_id"), 
                        rs.getString("service_name"), rs.getString("description"), rs.getString("firstname"),
                rs.getString("lastname"));
                result.add(viewService);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
//            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            /**
             * close result set, prepared statement and connection by
             * corresponding order
             */
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return result;
    }



    @Override
    public int addService(Service service) {
//        logger.log(Level.INFO, "Add service");
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("insert into services (service_name, Description)\n"
                    + "values (?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setString(2, service.getServiceDescription());

            int row = preparedStatement.executeUpdate();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return 0;
    }

    public int addServiceX(Service service) {
//        logger.log(Level.INFO, "Add service");
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
//        try {
//            connecion = getConnection();
//            // Get data
//            preparedStatement = connecion.prepareStatement("insert into services (service_name, description)\n"
//                    + "values (?,?)", Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1, service.getServiceName());
//            preparedStatement.setString(2, service.getServiceDescription());
//
//            int row = preparedStatement.executeUpdate();
//            return row;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            closePreparedStatement(preparedStatement);
//            closeConnection(connecion);
//        }

        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("insert into services (service_name, description)\n"
                    + "values (?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setString(2, service.getServiceDescription());

            int row = preparedStatement.executeUpdate();
            return row;
        } catch (SQLException ex) {
//            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public int getIdInserted() {

        String sql = "SELECT MAX(service_id) as id FROM services";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
//            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
//            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return 0;
    }

    @Override
    public void updateService(Service service) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("update services set service_name = ? , service_description = ? where service_id = ?");
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setString(2, service.getServiceDescription());
            preparedStatement.setInt(3, service.getServiceId());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }
public void updateService(int id, String name, String description) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("update services set service_name = ? , description = ? where service_id = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }
    @Override
    public void removeAllDoctor(int id) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("update users set service_id = null where service_id = ? and role_id = 3");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }

 @Override
    public void deleteService(int id) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("update services set isActive = 0 where service_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }

    @Override
    public Pagination<ServiceDTO> getAllService(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
