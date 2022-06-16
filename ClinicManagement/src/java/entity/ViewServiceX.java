/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author TuDA
 */
public class ViewServiceX {
  private int service_id;
    private String service_name;
    private String desc;
    private String fname;
    private String lname;

    public ViewServiceX() {
    }

    public ViewServiceX(int service_id, String service_name, String desc, String fname, String lname) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.desc = desc;
        this.fname = fname;
        this.lname = lname;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
