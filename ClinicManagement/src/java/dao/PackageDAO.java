/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.ServicePackage;
import java.util.List;
import model.Pagination;

/**
 *
 * @author Administrator
 */
public interface PackageDAO {
    List<ServicePackage> getAllPackage();
     public Pagination<ServicePackage> getPackageService(int pageIndex, int pageSize);
      public void updatePackageService(ServicePackage sp);

    public void getById(int serviceId);

    public void deletePackageService(int id);

    public ServicePackage getByIdPackage(int id);
    
     public void addPackageService(ServicePackage sp);
}
