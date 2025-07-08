package peaksoft.springbootinstagrammvs.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.springbootinstagrammvs.entites.Post;
import peaksoft.springbootinstagrammvs.entites.User;
import peaksoft.springbootinstagrammvs.service.PostService;
import peaksoft.springbootinstagrammvs.service.UserService;
import java.time.LocalDateTime;
import java.util.List;



@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute("newPost") Post post,
                           @RequestParam("imageUrls") List<String> imageUrls) {
        if (imageUrls == null || imageUrls.isEmpty() || imageUrls.stream().allMatch(String::isBlank)) {
            return "redirect:/posts/new?error=missingImage";
        }

        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            return "redirect:/signin/";
        }

        post.setCratedAt(LocalDateTime.now());
        post.setUser(currentUser);
        post.setLikeCount(0);

        List<String> cleanedImageUrls = imageUrls.stream()
                .filter(url -> url != null && !url.isBlank())
                .toList();

        post.setImages(cleanedImageUrls);
        postService.save(post);

        return "redirect:/profile/" + currentUser.getId();
    }
    @GetMapping("/new")
    public String createPostPage(Model model) {
        model.addAttribute("newPost", new Post());
        return "newPost";

     }

    // 🟠 UPDATE PAGE (формага өтүү)
    @GetMapping("/editPost/{postId}")
    public String editPage(@PathVariable Long postId, Model model) {
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);
        return "editPost";

    }
    @PostMapping("/posts/{id}/update")
    public String updatePost(@PathVariable Long id,
                             @RequestParam String description) {
        postService.updatePost(id, description);
        return "redirect:/profile";
    }

}