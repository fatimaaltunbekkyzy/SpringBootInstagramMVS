package peaksoft.springbootinstagrammvs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.springbootinstagrammvs.entites.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    // Sign in by email and password
    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    Optional<User> signIn(@Param("email") String email, @Param("password") String password);

//    // Search by username (full name издөө үчүн кошумча table керек)
//    @Query("SELECT u FROM User u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :username, '%'))")
//    List<User> search(@Param("keyword") String username);
}
