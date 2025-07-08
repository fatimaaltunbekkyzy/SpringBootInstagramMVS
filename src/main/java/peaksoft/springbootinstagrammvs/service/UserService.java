package peaksoft.springbootinstagrammvs.service;

import peaksoft.springbootinstagrammvs.entites.User;
import peaksoft.springbootinstagrammvs.entites.UserInfo;

import java.util.List;

public interface UserService {
    //TODO CRUD METHODS
    User singUp(User user);

    User signIn(User user);

    void save(User user);

    List<User> getAllUser();

    User findById(Long id);

    void updateUser(Long id,User user);

    void deleteUser(Long id);
    //TODO KOSHYMCHA METHODS

//    List<User>getUserProfile();

//    List<User> search(String username);

    User getUserById(Long userId);

    User getCurrentUser();
}
