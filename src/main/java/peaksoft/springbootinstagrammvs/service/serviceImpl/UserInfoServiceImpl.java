package peaksoft.springbootinstagrammvs.service.serviceImpl;

import org.springframework.stereotype.Service;
import peaksoft.springbootinstagrammvs.entites.UserInfo;
import peaksoft.springbootinstagrammvs.repo.UserInfoRepo;
import peaksoft.springbootinstagrammvs.service.UserInfoService;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoRepo userInfoRepo;

    public UserInfoServiceImpl(UserInfoRepo userInfoRepo) {
        this.userInfoRepo = userInfoRepo;
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfoRepo.save(userInfo);
    }
}
