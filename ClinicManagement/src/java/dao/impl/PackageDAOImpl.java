/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.DBContext;
import dao.PackageDAO;
import entity.Pagination;
import entity.Service;
import entity.ServicePackage;
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
    
}
