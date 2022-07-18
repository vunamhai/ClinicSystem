/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Account;
import model.Blog;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface BlogDAO {
public ArrayList<Blog> getAllBlogs(); 
  public void AddBlog(Blog blog);
   public void updateBlog(Blog blog);
   public void deleteBlog(int id);
        }
