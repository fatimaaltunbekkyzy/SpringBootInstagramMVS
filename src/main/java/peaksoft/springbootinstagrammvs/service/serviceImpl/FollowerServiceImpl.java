package peaksoft.springbootinstagrammvs.service.serviceImpl;

import org.springframework.stereotype.Service;
import peaksoft.springbootinstagrammvs.entites.Follower;
import peaksoft.springbootinstagrammvs.repo.FollowerRepo;
import peaksoft.springbootinstagrammvs.service.FollowerService;

@Service
public class FollowerServiceImpl implements FollowerService {
    private final FollowerRepo followerRepo;

    public FollowerServiceImpl(FollowerRepo followerRepo) {
        this.followerRepo = followerRepo;
    }

    @Override
    public void save(Follower follower) {
      followerRepo.save(follower);
    }
}
