package com.morenkov.morestat.repository;

import com.morenkov.morestat.dto.users.basicinfo.UserInfoData;
import com.morenkov.morestat.entity.UserStateSnapshot;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author emorenkov
 */
public interface UserRepository extends MongoRepository<UserStateSnapshot, String> {

}
