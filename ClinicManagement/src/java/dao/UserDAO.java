
package dao;

import model.Account;
import model.Doctor;
import model.Pagination;
import model.User;
import java.util.List;


public interface UserDAO {

    User login(String username, String password);

    /**
     * - Get all account with infomation
     *
     * @param pageIndex
     * @param pageSize
     * @return a list of <code>Account</code> objects. <br>
     * -It is a <code>java.util.List</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     */
    Pagination<User> getAllActiveAccount(int pageIndex, int pageSize, String search);
    
    Pagination<User> getAllAccount(int pageIndex, int pageSize, String search);

    void deleteAccount(int id);

    void updateAccount(User user);

    void createAccount(User user);
    
    void updateStatusAccount(int id, boolean status);

    void addDoctorForService(int doctor, int service);

    List<Doctor> getAllDoctor();

    List<Doctor> getDoctorByServiceId(int id);

    void updateAccountByAdmin(User user);

    User getUserById(int id);

    boolean checkUsernameAndEmail(String username, String email);

    void updatePassword(String username, String password);

    User getUserByEmail(String email);
}
