package com.morenkov.morestat.repository;

import com.morenkov.morestat.entity.UserStateSnapshotEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author emorenkov
 */
public interface UserRepository extends MongoRepository<UserStateSnapshotEntity, String> {

}
