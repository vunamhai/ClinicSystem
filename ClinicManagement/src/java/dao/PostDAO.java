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

    public Pagination<PostEntity> getAllPosts(int pageIndex, int pageSize, String search);
}
