/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import context.DBContext;
import dao.PackageDAO;
import model.Pagination;
import model.Service;
import model.ServicePackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class PackageDAOImpl extends DBContext implements PackageDAO {

    @Override
    public List<ServicePackage> getAllPackage() {
        Connection connecion = null; 
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<ServicePackage> packages = new ArrayList<>();
        try {
  
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("select * from packages");

            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ServicePackage p = new ServicePackage();
                p.setPackageId(rs.getInt("package_id"));
                p.setExaminationDuration(rs.getString("examination_duration"));
                p.setPrice(rs.getInt("price"));
                p.setPackageTitle(rs.getString("package_title"));
                packages.add(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return packages;
    }
    @Override
    public Pagination<ServicePackage> getPackageService(int pageIndex, int pageSize) {
        Pagination<ServicePackage> pagination = new Pagination<>(); // pagination package

        logger.log(Level.INFO, "getAllService");
        Connection connecion = null; // connection database
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<ServicePackage> ServicePackage = new ArrayList<>();// list all package
        try {
            int totalItem = count(); // count total package
            pagination.setCurrentPage(pageIndex);
            pagination.setItemPerPage(pageSize);
            pagination.setTotalItem(totalItem);

            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement(""
                    + "SELECT  *\n"
                    + "FROM (SELECT ROW_NUMBER() OVER ( ORDER BY package_id )\n"
                    + "AS RowNum, * FROM  packages) \n"
                    + "AS RowConstrainedResult\n"
                    + "WHERE   RowNum >= ?\n"
                    + "    AND RowNum <= ?\n"
                    + "ORDER BY RowNum");
            preparedStatement.setInt(1, (pageIndex - 1) * pageSize);
            preparedStatement.setInt(2, (pageIndex - 1) * pageSize + pageSize);
            //excute query
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ServicePackage Spackage = new ServicePackage();
                Spackage.setPackageId(rs.getInt("package_id"));
                Spackage.setPackageTitle(rs.getString("package_title"));
                Spackage.setExaminationDuration(rs.getString("examination_duration"));
                Spackage.setPrice((rs.getFloat("price")));
                ServicePackage.add(Spackage);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        pagination.setData(ServicePackage);// paging for list services
        return pagination;
    }
     public int count() {
        Connection connecion = null;
        PreparedStatement countPreparedStatement = null;
        ResultSet countResultSet = null;
        try {
            connecion = getConnection();
            countPreparedStatement = connecion.prepareStatement("SELECT COUNT(package_id) AS id FROM packages;");
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

    @Override
    public void updatePackageService(ServicePackage sp) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("UPDATE [dbo].[packages]\n"
                    + "   SET [package_title] =?\n"
                    + "      ,[examination_duration] = ?\n"
                    + "      ,[price] = ?\n"
                    + " WHERE [package_id]=?");
            preparedStatement.setString(1, sp.getPackageTitle());
            preparedStatement.setString(2, sp.getExaminationDuration());
            preparedStatement.setFloat(3, sp.getPrice());
            preparedStatement.setInt(4, sp.getPackageId());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(PackageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }

    @Override
    public void getById(int serviceId) {
        logger.log(Level.INFO, "getById");
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        ServicePackage sp = new ServicePackage();
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("select * from packages where package_id=?");
            preparedStatement.setInt(1, serviceId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sp.setPackageId(rs.getInt("package_id"));
                sp.setPackageTitle(rs.getString("package_title"));
                sp.setExaminationDuration(rs.getString("examination_duration"));
                sp.setPrice(rs.getFloat("price"));

            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }

    }

    @Override
    public void deletePackageService(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ServicePackage getByIdPackage(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPackageService(ServicePackage sp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
