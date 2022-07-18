/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 tungnt           First Implement 
 */
package dao;

import static config.Configuration.PAGE_SIZE;
import entity.Examination;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class is an interface contains methods of Examination
 *
 * @author Nguyễn Thanh Tùng
 */
public interface ExaminationDAO {

    /**
     * - Get full information about a examination (such as customer information,
     * service information, package information, all examination information)
     *
     * @param userId is a <code>java.lang.int</code> object used to get
     * examination by userId
     *
     * @return a list of <code>Examination</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public ArrayList<Examination> getExamninationByUserId(int userId, int PAGE_SIZE, int currentPage) throws SQLException, Exception;

    /**
     * - Get full information about a examination (such as customer information,
     * service information, package information, all examination information)
     *
     * @param examinationId is a <code>java.lang.int</code> object used to get
     * examination by examinationId
     *
     * @return a <code>Examination</code> objects. <br>
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public Examination getExamninationById(int examinationId) throws SQLException, Exception;

    /**
     * - insert new examination after execute examination
     *
     * @param reservationId is a <code>java.lang.int</code> object used to add
     * new examination
     * @param doctorId is a <code>java.lang.int</code> object used to add new
     * examination
     * @param examinationDisgosis is a <code>java.lang.String</code> object used
     * to add new examination
     * @param examinationPrescription is a <code>java.lang.String</code> object
     * used to add new examination
     * @param examinationDate is a <code>java.lang.Date</code> object used to
     * add new examination
     *
     * @return a <code>Examination</code> objects. <br>
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public int insertNewExamination(int reservationId, int doctorId, String examinationDisgosis, String examinationPrescription, Date examinationDate) throws SQLException, Exception;

    /**
     * - Get number of examination by user id
     *
     * @param userId is a <code>java.lang.int</code> object used to get
     * examination by userId
     *
     * @return a list of <code>Examination</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public int countExamninationByUserId(int userId) throws SQLException, Exception;
}
