/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version          AUTHOR           DESCRIPTION
 * 2022-02-08      1.0              HuongHTT         First Implement 
 */
package dao;



import entity.Account;
import entity.Account1;
import entity.Accounts;
import java.util.List;

/**
 * This is an interface contains methods of <code>User</code> object<br>
 *
 * Bugs: none
 *
 * @author Hoang Thi Thu Huong
 */
public interface AccountDAO {

    Account1 login(String username, String password);
    void createAccount(Account account);
    public List<Accounts> getAllAccounts();
    public void addAccounts(Accounts a);
    public void deleteAccounts(int id);
    public void updateAccounts(Accounts a);
    public Accounts getAccountById(int id);
    public Accounts getAccountByUsername(String username);
    public Accounts getAccountByEmail(String email);
}
