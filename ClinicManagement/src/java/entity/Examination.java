package entity;

import java.sql.Date;

/**
 * @author uyenc
 */
public class Examination {

    private int examinationId;
    private Reservation reservation;
    private User doctor;
    private String examinationDisgnosis;
    private String examinationPrescription;
    private Date examinationDate;

    /**
     * Create an instance of <code>Examination</code> object
     */
    public Examination() {
    }

    /**
     * Create an instance of <code>Examination</code> object with value of
     * attributes of <code>Examination</code>
     *
     * @param examinationId the value of examinationId attribute. It's a
     * <code>java.lang.int</code> object
     * @param reservation the value of reservation attribute. It's a
     * <code>entity.Reservation</code> object
     * @param doctor the value of doctor attribute. It's a
     * <code>entity.User</code> object
     * @param examinationDisgnosis the value of examinationDisgnosis attribute.
     * It's a <code>java.lang.String</code> object
     * @param examinationPrescription the value of examinationPrescription
     * attribute. It's a <code>java.lang.String</code> object
     * @param examinationDate the value of examinationDate attribute. It's a
     * <code>java.lang.Date</code> object
     */
    public Examination(int examinationId, Reservation reservation, User doctor, String examinationDisgnosis, String examinationPrescription, Date examinationDate) {
        this.examinationId = examinationId;
        this.reservation = reservation;
        this.doctor = doctor;
        this.examinationDisgnosis = examinationDisgnosis;
        this.examinationPrescription = examinationPrescription;
        this.examinationDate = examinationDate;
    }

    /**
     * Return the value of examinationId attribute of the
     * <code>Examination</code> object.
     */
    public int getExaminationId() {
        return examinationId;
    }

    /**
     * Set examinationId value of the <code>Examination</code> object.
     *
     * @param examinationId is a <code>java.lang.int</code> this value is the id
     * of the <code>Examination</code> object.
     */
    public void setExaminationId(int examinationId) {
        this.examinationId = examinationId;
    }

    /**
     * Return the value of reservation attribute of the <code>Examination</code>
     * object.
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * Set reservation value of the <code>Examination</code> object.
     *
     * @param reservation is a <code>entity.Reservation</code> this value is the
     * reservation of the <code>Examination</code> object.
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    /**
     * Return the value of doctor attribute of the <code>Examination</code>
     * object.
     */
    public User getDoctor() {
        return doctor;
    }

    /**
     * Set doctor value of the <code>Examination</code> object.
     *
     * @param doctor is a <code>entity.User</code> this value is the doctor of
     * the <code>Examination</code> object.
     */
    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    /**
     * Return the value of examinationDisgnosis attribute of the
     * <code>Examination</code> object.
     */
    public String getExaminationDisgnosis() {
        return examinationDisgnosis;
    }

    /**
     * Set examinationDisgnosis value of the <code>Examination</code> object.
     *
     * @param examinationDisgnosis is a <code>java.lang.String</code> this value
     * is the examinationDisgnosis of the <code>Examination</code> object.
     */
    public void setExaminationDisgnosis(String examinationDisgnosis) {
        this.examinationDisgnosis = examinationDisgnosis;
    }

    /**
     * Return the value of examinationPrescription attribute of the
     * <code>Examination</code> object.
     */
    public String getExaminationPrescription() {
        return examinationPrescription;
    }

    /**
     * Set examinationPrescription value of the <code>Examination</code> object.
     *
     * @param examinationPrescription is a <code>java.lang.String</code> this
     * value is the examinationPrescription of the <code>Examination</code>
     * object.
     */
    public void setExaminationPrescription(String examinationPrescription) {
        this.examinationPrescription = examinationPrescription;
    }

    /**
     * Return the value of examinationDate attribute of the
     * <code>Examination</code> object.
     */
    public Date getExaminationDate() {
        return examinationDate;
    }

    /**
     * Set examinationDate value of the <code>Examination</code> object.
     *
     * @param examinationDate is a <code>java.sql.Date</code> this value is the
     * examinationDate of the <code>Examination</code> object.
     */
    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
    }

}
