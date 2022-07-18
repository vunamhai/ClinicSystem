package dao;

import model.FeedbackDTO;
import model.Feedback;
import model.FeedbackReply;
import model.Pagination;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Cuong
 */
public interface FeedbackDAO {

    Pagination<FeedbackDTO> getAllFeedback(int pageIndex, int pageSize, String time);

    void addFeedback(Feedback feedback);

    Pagination<FeedbackDTO> getAllFeedback(int pageIndex, int pageSize, int service, String time);

    List<Date> getAllDate();

    Pagination<FeedbackDTO> getAllCustomerFeedback(int pageIndex, int pageSize, String time, int id);

    Pagination<FeedbackDTO> getAllCustomerFeedback(int pageIndex, int pageSize, int service, String time, int id);
    
     List<FeedbackReply> getAllReply();

}
