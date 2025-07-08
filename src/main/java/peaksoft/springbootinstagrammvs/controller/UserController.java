package peaksoft.springbootinstagrammvs.controller;

import jakarta.persistence.NoResultException;
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
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final FollowerService followerService;
    private final PostService postService;

    public UserController(UserService userService, FollowerService followerService,PostService postService) {
        this.userService = userService;
        this.followerService = followerService;
        this.postService = postService;

    }

    @GetMapping()
    public String signInForm(Model model) {
        model.addAttribute("user", new User());
        return "signin";
    }

    @PostMapping("/signIn")
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
    public String userProfile(@PathVariable("userId") Long userId, Model model) {

        User profile = userService.getUserById(userId);
        model.addAttribute("user", profile);

        UserInfo userInfo = profile.getUserInfo();
        model.addAttribute("userInfo", userInfo != null ? userInfo : new UserInfo());

        Follower follower = profile.getFollower();
        model.addAttribute("follower", follower != null ? follower : new Follower());

        List<Post> posts = postService.getAllPostsByUserId(userId);
        model.addAttribute("posts", posts);

        return "profilePage";

}}