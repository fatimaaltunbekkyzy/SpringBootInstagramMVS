package peaksoft.springbootinstagrammvs.service;

public interface FollowerService {
    boolean isSubscribed(Long id, Long userId);
}
