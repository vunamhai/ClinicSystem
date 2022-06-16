/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.BlogDAO;
import context.DBContext;
import entity.Account;
import entity.Blog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BlogDAOImpl extends DBContext implements BlogDAO{

    @Override
    public ArrayList<Blog> getAllBlogs() {
       Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("SELECT [id]\n" +                  
"      ,[title]\n" +
"      ,[description]\n" +
"  FROM [dbo].[Blogs]");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
              Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
               blog.setDescription(rs.getString("description"));
                blogs.add(blog);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return null;}
  
  
     @Override
    public void AddBlog (Blog blog) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("INSERT INTO [dbo].[Blogs]\n" +
"           ([title]\n" +
"           ,[description])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?)");
            preparedStatement.setString(1, blog.getTitle() );
            preparedStatement.setString(2, blog.getDescription());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(BlogDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }
      @Override
    public void updateBlog(Blog blog) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("UPDATE [dbo].[Blogs]\n" +
"   SET [title] = ?	\n" +                  
"      ,[description] = ?\n" +
" WHERE id =?");
            preparedStatement.setString(1, blog.getTitle());
            preparedStatement.setString(2, blog.getDescription());
            preparedStatement.setInt(3, blog.getId());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }
     @Override
    public void deleteBlog(int id) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("DELETE FROM [dbo].[Blogs]\n" +
"      WHERE id= ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }
}
