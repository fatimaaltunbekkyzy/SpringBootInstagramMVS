package peaksoft.springbootinstagrammvs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springbootinstagrammvs.entites.UserInfo;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {

}
