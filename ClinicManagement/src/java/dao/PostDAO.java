/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.PostEntity;
import java.util.List;
import model.Pagination;

public interface PostDAO {

    List<PostEntity> getAllPost();

    List<PostEntity> searchPost(String value);

    PostEntity getPostById(int id);
    
    public String updatePostByManager(PostEntity p);

    public void deletePostById(int id);

     public int addPost(PostEntity post);

    public Pagination<PostEntity> getAllPosts(int pageIndex, int pageSize, String search);
}
