package peaksoft.springbootinstagrammvs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springbootinstagrammvs.entites.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
