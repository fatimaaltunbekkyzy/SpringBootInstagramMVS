package peaksoft.springbootinstagrammvs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.springbootinstagrammvs.entites.Post;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
    @Query("SELECT p FROM Post p WHERE p.user.id = :userId")
    List<Post> getAllPostsByUserId(Long userId);

    @Query("""
    SELECT p FROM Post p 
    WHERE p.user.id = :userId 
       OR p.user.id IN (
            SELECT f.subscribers FROM Follower f WHERE f.subscription = :userId
       )
    ORDER BY p.cratedAt DESC
""")
    List<Post> findNewsFeed(@Param("userId") Long userId);
}
