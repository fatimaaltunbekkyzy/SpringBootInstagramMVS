package peaksoft.springbootinstagrammvs.service;

import peaksoft.springbootinstagrammvs.entites.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPostsByUserId(Long userId);
}
