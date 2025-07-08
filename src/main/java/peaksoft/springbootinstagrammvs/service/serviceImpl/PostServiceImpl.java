package peaksoft.springbootinstagrammvs.service.serviceImpl;
import org.springframework.stereotype.Service;
import peaksoft.springbootinstagrammvs.entites.Post;
import peaksoft.springbootinstagrammvs.repo.PostRepo;
import peaksoft.springbootinstagrammvs.service.PostService;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public void save(Post post) {
        if (post.getImages() == null || post.getImages().isEmpty()) {
            throw new IllegalArgumentException("Сүрөт жок болсо пост түзүлбөйт!");
        }

        post.setCratedAt(LocalDateTime.now());
        post.setLikeCount(0); // лайктын саны 0
        postRepo.save(post);
    }

    @Override
    public Post findById(Long id) {
        return postRepo.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("Post with id not found",id)));
    }

    @Override
    public void updatePost(Long id, String newDescription) {
Post post1 = postRepo.findById(id).orElseThrow(()->
        new NullPointerException(String.format("Post with id not found",id)));
post1.setDescription(newDescription);
postRepo.save(post1);
    }

    @Override
    public void deletePost(Long id) {
postRepo.deleteById(id);
    }

    @Override
    public List<Post> getAllPostsByUserId(Long userId) {
        return postRepo.getAllPostsByUserId(userId);
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepo.findById(postId).orElseThrow(()->
                new NullPointerException(String.format("Post with id not found",postId)));
    }

    @Override
    public List<Post> findNewsFeed(Long userId) {
        return List.of();
    }
}
