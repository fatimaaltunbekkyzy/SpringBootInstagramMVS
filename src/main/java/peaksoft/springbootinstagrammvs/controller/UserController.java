package peaksoft.springbootinstagrammvs.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.springbootinstagrammvs.entites.Follower;
import peaksoft.springbootinstagrammvs.entites.Post;
import peaksoft.springbootinstagrammvs.entites.User;
import peaksoft.springbootinstagrammvs.entites.UserInfo;
import peaksoft.springbootinstagrammvs.service.FollowerService;
import peaksoft.springbootinstagrammvs.service.PostService;
import peaksoft.springbootinstagrammvs.service.UserService;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    private final FollowerService followerService;
    private final PostService postService;

    public UserController(UserService userService, FollowerService followerService, PostService postService) {
        this.userService = userService;
        this.followerService = followerService;
        this.postService = postService;

}
    @GetMapping()
    public String signInForm(Model model) {
        model.addAttribute("user", new User());
        return "signin";
    }

    @PostMapping("/singIn")
    public String signIn(@ModelAttribute("user") User user, Model model) {
        User foundUser = userService.signIn(user);

        if (foundUser == null || !foundUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("errorMessage", "Invalid email or password");
            return "signin";
        }
        return "redirect:/users/profile/" + foundUser.getId();
    }
    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }
    // Save new user
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users/all";

    }
    // All Users page
    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "mainpage";

    }
    @GetMapping("/profile/{userId}")
    public String userProfile(@PathVariable("userId") Long userId, Model model, HttpSession session) {
        User profile = userService.getUserById(userId);
        model.addAttribute("user", profile);

        UserInfo userInfo = profile.getUserInfo();
        model.addAttribute("userInfo", userInfo);

        Follower follower = profile.getFollowers();
        model.addAttribute("follower", follower);

        List<Post> posts = postService.getAllPostsByUserId(userId);
        model.addAttribute("posts", posts);

        User currentUser = (User) session.getAttribute("currentUser");
        boolean isSubscribed = false; // default
        if (currentUser != null && !currentUser.getId().equals(userId)) {
            isSubscribed = followerService.isSubscribed(currentUser.getId(), userId);
        }
        model.addAttribute("isSubscribed", isSubscribed);

        return "profilePage";

    }
    @GetMapping("/search")
    public String searchUsers(@RequestParam("keyword") String keyword, Model model) {
        List<User> users = userService.searchByUsername(keyword);
        model.addAttribute("users", users);
        return "userSearch"; // Бул баракчада users тизмеси көрсөтүлөт
    }
    @GetMapping("/simple-profile/{id}")
    public String viewProfile(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "userProfile"; // же башка баракчанын аталышы
    }
}
