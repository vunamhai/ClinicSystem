/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author uyenc
 */
public class ServicePackage {

    private int packageId;
    private String packageTitle;
    private String examinationDuration;
    private float price;

    public ServicePackage() {
    }

    public ServicePackage(String packageTitle) {
        this.packageTitle = packageTitle;
    }

    public ServicePackage(int packageId, String packageTitle, String examinationDuration) {
        this.packageId = packageId;
        this.packageTitle = packageTitle;
        this.examinationDuration = examinationDuration;
    }

    public ServicePackage(int packageId, String packageTitle, String examinationDuration, float price) {
        this.packageId = packageId;
        this.packageTitle = packageTitle;
        this.examinationDuration = examinationDuration;
        this.price = price;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getPackageTitle() {
        return packageTitle;
    }

    public void setPackageTitle(String packageTitle) {
        this.packageTitle = packageTitle;
    }

    public String getExaminationDuration() {
        return examinationDuration;
    }

    public void setExaminationDuration(String examinationDuration) {
        this.examinationDuration = examinationDuration;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
