/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Nam Ngo
 */
public class SQLCommands {
    public static String GET_ALL_ACCOUNTS="select * from Accounts";
    public static String GET_ALL_ROLES="select * from Roles";
    public static String GET_ACCOUNT_BY_ID="select * from Accounts where ID= ?";
    public static String GET_ACCOUNT_BY_EMAIL="select * from Accounts where Email= ?";
    public static String GET_ACCOUNT_BY_USERNAME="select * from Accounts where UserName= ?";
    public static String UPDATE_ACCOUNT_BY_ID="update Accounts set UserName=?, FirstName=?, LastName=?, Email=?, Street=?, City=?, Country=?, Phone=?, DoB=?, Gender=? where ID=?";
    public static String ADD_ACCOUNT="insert into Accounts(UserName,FirstName,LastName,Email,Street,City,Country,Phone,DoB,Gender,[Password]) values (?,?,?,?,?,?,?,?,?,?,?)";
    public static String UPDATE_PASSWORD_BY_ID="update Accounts set [Password]=? where ID=?";
}
