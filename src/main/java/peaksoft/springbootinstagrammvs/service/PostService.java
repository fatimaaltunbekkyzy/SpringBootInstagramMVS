package peaksoft.springbootinstagrammvs.service;
import org.springframework.data.repository.query.Param;
import peaksoft.springbootinstagrammvs.entites.Post;
import peaksoft.springbootinstagrammvs.entites.User;

import java.util.List;

public interface PostService {

    void save(Post post);

    Post findById(Long id);

    void updatePost(Long id,String newDescription);

    void deletePost(Long id);

    List<Post> getAllPostsByUserId(Long userId);

    Post getPostById(Long postId);

    List<Post> findNewsFeed(Long userId);

}
