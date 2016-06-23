package com.morenkov.morestat.repository;

import com.morenkov.morestat.dto.UserStateSnapshot;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author emorenkov
 */
public interface UserStateSnapshotRepository extends MongoRepository<UserStateSnapshot, String> {

}
