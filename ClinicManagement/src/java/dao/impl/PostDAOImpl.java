/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.DBContext;
import dao.PostDAO;
import model.PostEntity;
import model.ServicePackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pagination;

public class PostDAOImpl extends DBContext implements PostDAO {
    /**
     * Logger for system
     */
    private static Logger logger = Logger.getLogger(PostDAOImpl.class.getName());
    
    public String getString(String msg) {
        StringBuilder output = new StringBuilder();

        String[] tempStr = msg.trim().split("\\s+");
        for (String string : tempStr) {
            output.append(string).append(" ");
        }
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }


    public Pagination<PostEntity> getAllPosts(int pageIndex, int pageSize, String string) {

        Pagination<PostEntity> pagination = new Pagination<>(); // pagination services

        logger.log(Level.INFO, "getAllPosts");
        Connection connecion = null; // connection database
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        String search = getString(string);
        List<PostEntity> posts = new ArrayList<>();// list all services
        try {
            int totalItem = count(); // count total service
            pagination.setCurrentPage(pageIndex);
            pagination.setItemPerPage(pageSize);
            pagination.setTotalItem(totalItem);

            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement(""
                    + "SELECT  *\n"
                    + "FROM (SELECT ROW_NUMBER() OVER ( ORDER BY id )\n"
                    + "AS RowNum, * FROM  posts as p where (p.title like N'%" + search + "%' or [title] like '%" + search + "%'))\n"
                    + "AS RowConstrainedResult\n"
                    + "WHERE   RowNum >= ?\n"
                    + "AND RowNum <= ?\n"
                    + "ORDER BY RowNum");

            preparedStatement.setInt(1, (pageIndex - 1) * pageSize);
            preparedStatement.setInt(2, (pageIndex - 1) * pageSize + pageSize);
            //excute query
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PostEntity post = new PostEntity();
                post.setId(rs.getInt("id"));
                post.setUserId(rs.getInt("user_id"));
                post.setTitle(rs.getString("title"));
                post.setSummary(rs.getString("summary"));
                post.setContent(rs.getString("content"));
                post.setCreateDate(rs.getDate("create_date"));
                post.setCreateTime(rs.getString("create_time"));
                post.setPostImage(rs.getString("post_images"));
                posts.add(post);
            }
        } catch (Exception ex) {
            Logger.getLogger(PostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        pagination.setData(posts);// paging for list services
        return pagination;
    }

    public int count() {
        Connection connecion = null;
        PreparedStatement countPreparedStatement = null;
        ResultSet countResultSet = null;
        try {
            connecion = getConnection();
            countPreparedStatement = connecion.prepareStatement("SELECT COUNT(id) AS id FROM posts;");
            countResultSet = countPreparedStatement.executeQuery();
            if (countResultSet.next()) {
                // get and return count total posts
                return countResultSet.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(countResultSet);
            closePreparedStatement(countPreparedStatement);
            closeConnection(connecion);
        }
        return 0;
    }


    @Override
    public List<PostEntity> getAllPost() {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<PostEntity> posts = new ArrayList<>();
        try {

            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("select * from posts");

            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PostEntity p = new PostEntity();
                p.setId(rs.getInt("id"));
                p.setUserId(rs.getInt("user_id"));
                p.setTitle(rs.getString("title"));
                p.setSummary(rs.getString("summary"));
                p.setContent(rs.getString("content"));
                p.setCreateDate(rs.getDate("create_date"));
                p.setCreateTime(rs.getString("create_time"));
                p.setPostImage(rs.getString("post_images"));
                posts.add(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return posts;
    }

    @Override
    public List<PostEntity> searchPost(String value) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<PostEntity> posts = new ArrayList<>();
        try {

            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("select * from posts where title like '%" + value + "%'");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PostEntity p = new PostEntity();
                p.setId(rs.getInt("id"));
                p.setUserId(rs.getInt("user_id"));
                p.setTitle(rs.getString("title"));
                p.setSummary(rs.getString("summary"));
                p.setContent(rs.getString("content"));
                p.setCreateDate(rs.getDate("create_date"));
                p.setCreateTime(rs.getString("create_time"));
                p.setPostImage(rs.getString("post_images"));
                posts.add(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return posts;
    }

    @Override
    public PostEntity getPostById(int id) {
             Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<PostEntity> posts = new ArrayList<>();
        try {

            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("select * from posts where id = ?");
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PostEntity p = new PostEntity();
                p.setId(rs.getInt("id"));
                p.setUserId(rs.getInt("user_id"));
                p.setTitle(rs.getString("title"));
                p.setSummary(rs.getString("summary"));
                p.setContent(rs.getString("content"));
                p.setCreateDate(rs.getDate("create_date"));
                p.setCreateTime(rs.getString("create_time"));
                p.setPostImage(rs.getString("post_images"));
                return p;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return null;
    }
    
    @Override
    public String updatePostByManager(PostEntity post) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("UPDATE [dbo].[posts]\n"
                    + "   SET\n"
                    + "       [title] = ?\n"
                    + "      ,[summary] = ?\n"
                    + "      ,[content] = ?\n"
                    + "      ,[post_images] = ?\n"
                    + " WHERE id = ?");

            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getSummary());
            preparedStatement.setString(3, post.getContent());
            preparedStatement.setString(4, post.getPostImage());
            preparedStatement.setInt(5, post.getId());

            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return "success";
    }

    @Override
    public void deletePostById(int id) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement
                    = connecion.prepareStatement(" DELETE FROM [dbo].[posts]\n"
                            + "      WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }

    @Override
    public int addPost(PostEntity post) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("INSERT INTO [dbo].[posts]\n"
                    + "           ([user_id]\n"
                    + "           ,[title]\n"
                    + "           ,[summary]\n"
                    + "           ,[content]\n"
                    + "           ,[create_date]\n"
                    + "           ,[create_time]\n"
                    + "           ,[post_images])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, post.getUserId());
            preparedStatement.setString(2, post.getTitle());
            preparedStatement.setString(3, post.getSummary());
            preparedStatement.setString(4, post.getContent());
            preparedStatement.setDate(5, post.getCreateDate());
            preparedStatement.setString(6, post.getCreateTime());
            preparedStatement.setString(7, post.getPostImage());

            int row = preparedStatement.executeUpdate();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return 0;
    }

}
