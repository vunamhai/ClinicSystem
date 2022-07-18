
package dao.impl;

import context.DBContext;
import dao.FeedbackReplyDAO;
import entity.FeedbackReply;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>Feedback Reply DAO</h1>
 * Data access object connect database and access data. - addFeedbackReply : add 
 *  feedback reply
 * service by id
 * <p>
 */
public class FeedbackReplyDAOImpl extends DBContext implements FeedbackReplyDAO {

    @Override
    public void addFeedbackReply(FeedbackReply feedbackReply) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement(" insert into feedback_replies (feedback_id, feedback_reply_content, feedback_reply_time)\n"
                    + "  values (?,?, ?)");
            preparedStatement.setInt(1, feedbackReply.getFeedback());
            preparedStatement.setString(2, feedbackReply.getContent());
            preparedStatement.setDate(3, feedbackReply.getDate());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }

}
