/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;



/**
 *
 * @author ADMIN
 */
public class Blog {
    private int id;
    private int account_id;
    private String title;
    private String description;

    public Blog() {
    }


//    public int getAccount_id() {
//        return account_id;
//    }
//
//    public void setAccount_id(int ccount_id) {
//        this.account_id = ccount_id;
//    }

    public Blog(int id , String title, String description) {
        this.id = id;
//        this.account_id = account_id;
        this.title = title;
        this.description = description;
    }

   

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blog(String title, String description) {
        this.title = title;
        this.description = description;
    }

   
    
}
