package peaksoft.springbootinstagrammvs.repo.repoImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springbootinstagrammvs.entites.Follower;
@Repository
public interface FollowerRepo extends JpaRepository<Follower,Long> {
}
