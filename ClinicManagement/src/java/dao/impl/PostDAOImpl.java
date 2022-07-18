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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostDAOImpl extends DBContext implements PostDAO {

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
                p.setCreateTime(rs.getTime("create_time"));
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
                p.setCreateTime(rs.getTime("create_time"));
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
                p.setCreateTime(rs.getTime("create_time"));
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

}
