/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-05-26      1.0                 UYENNP          Service DAO
 */
package dao;

//import entity.ServiceDTO;
//import entity.Pagination;

import entity.Pagination;
import entity.Service;
import entity.ServiceDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * <h1>Service DAO</h1>
 * Interface ServiceDAO. Method access and return data. Its method is implements
 * by ServiceDAOIpml class
 * <p>
 *
 *
 * @author UYENNP
 * @version 1.0
 * @since 2022-05-26
 */
public interface ServiceDAO {

    /**
     * Get all services
     *
     * @param pageIndex
     * @param pageSize
     * @return list services
     */
//    Pagination<ServiceDTO> getAllService(int pageIndex, int pageSize);

    /**
     * Count total service
     *
     * @return total service
     */
    int count();

    /**
     * Get service by id
     *
     * @param id
     * @return service
     */
    Service getById(int id);

    /**
     * - Get all services of clinic
     *
     * @return a list of <code>Service</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     */
    public ArrayList<Service> getServices() throws SQLException;

    public int addService(Service service);

    public int getIdInserted();

    public void updateService(Service service);

    public void removeAllDoctor(int id);

    public void deleteService(int id);
    
    List<Service> searchServices(String search);

  
 
}
