package peaksoft.springbootinstagrammvs.service.serviceImpl;
import org.springframework.stereotype.Service;
import peaksoft.springbootinstagrammvs.entites.Follower;
import peaksoft.springbootinstagrammvs.entites.User;
import peaksoft.springbootinstagrammvs.entites.UserInfo;
import peaksoft.springbootinstagrammvs.repo.UserRepo;
import peaksoft.springbootinstagrammvs.repo.repoImpl.FollowerRepo;
import peaksoft.springbootinstagrammvs.repo.repoImpl.UserInfoRepo;
import peaksoft.springbootinstagrammvs.service.UserService;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserInfoRepo userInfoRepo;
    private final FollowerRepo followerRepo;

    public UserServiceImpl(UserRepo userRepo, UserInfoRepo userInfoRepo, FollowerRepo followerRepo) {
        this.userRepo = userRepo;
        this.userInfoRepo = userInfoRepo;
        this.followerRepo = followerRepo;
}

    @Override
    public User singUp(User user) {

        User savedUser = userRepo.save(user);

        UserInfo userInfo = new UserInfo();
        userInfoRepo.save(userInfo);

        Follower follower = new Follower();
        followerRepo.save(follower);

        savedUser.setUserInfo(userInfo);
        savedUser.setFollower(follower);
        return userRepo.save(savedUser);
    }

    @Override
    public User signIn(User user) {
        return null;
    }

    @Override
    public void save(User user) {
    userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("User with id %s not found", id)));
    }

    @Override
    public void updateUser(Long id, User user) {
 User user1 = userRepo.findById(id).orElseThrow(()->
         new NullPointerException(String.format("User with id %s not found", id)));
 user1.setUsername(user.getUsername());
 user1.setEmail(user.getEmail());
 user1.setPassword(user.getPassword());
 user1.setPhone_number(user.getPhone_number());
 userRepo.save(user1);
    }

    @Override
    public void deleteUser(Long id) {
userRepo.deleteById(id);
    }

    @Override
    public List<User> getUserProfile() {
        return List.of();
    }

    @Override
    public List<User> searchByUsername(String username) {
        return null;
//        return userRepo.findByUser_UsernameContainingIgnoreCase(username);

    }

}
