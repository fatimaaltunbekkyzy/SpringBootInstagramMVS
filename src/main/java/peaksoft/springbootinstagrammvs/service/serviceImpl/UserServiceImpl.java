package peaksoft.springbootinstagrammvs.service.serviceImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Service;
import peaksoft.springbootinstagrammvs.entites.Follower;
import peaksoft.springbootinstagrammvs.entites.User;
import peaksoft.springbootinstagrammvs.entites.UserInfo;
import peaksoft.springbootinstagrammvs.repo.FollowerRepo;
import peaksoft.springbootinstagrammvs.repo.UserInfoRepo;
import peaksoft.springbootinstagrammvs.repo.UserRepo;
import peaksoft.springbootinstagrammvs.service.UserService;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserInfoRepo userInfoRepo;
    private final FollowerRepo followerRepo;

    public UserServiceImpl(UserRepo userRepo, UserInfoRepo userInfoRepo,FollowerRepo followerRepo) {
        this.userRepo = userRepo;
        this.userInfoRepo = userInfoRepo;
        this.followerRepo = followerRepo;
}

    @Override
    public User singUp(User user) {
        if (!user.getPhone_number().startsWith("+996")) {
            user.setPhone_number("+996" + user.getPhone_number());
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);
        user.setUserInfo(userInfo);

        Follower follower = new Follower();
        follower.setUser(user);
        follower.setSubscribers(0);
        follower.setSubscription(0);
        follower.setSubscribersList(new ArrayList<>());
        follower.setSubscriptionList(new ArrayList<>());
        user.setFollower(follower);

        userInfoRepo.save(userInfo);
        followerRepo.save(follower);
        return userRepo.save(user);

    }

    @Override
    public User signIn(User user) {
        return userRepo.signIn(user.getEmail(), user.getPassword())
                .orElse(null);
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
    public User getUserById(Long userId) {
        return userRepo.findById(userId).orElseThrow(()->
                new NullPointerException(String.format("User with id %s not found", userId)));
    }

    @Override
    public User getCurrentUser() {
        return  null;
    }}

























//        User savedUser = userRepo.save(user);
//
//        UserInfo userInfo = new UserInfo();
//        userInfoRepo.save(userInfo);
//
//        Follower follower = new Follower();
//        followerRepo.save(follower);
//
//        savedUser.setUserInfo(userInfo);
//        savedUser.setFollower(follower);
//        return userRepo.save(savedUser);