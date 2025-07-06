package peaksoft.springbootinstagrammvs.repo.repoImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.springbootinstagrammvs.entites.User;
import peaksoft.springbootinstagrammvs.entites.UserInfo;

import java.util.List;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {

    List<UserInfo> findByUser_UsernameContainingIgnoreCase(String username);

}
