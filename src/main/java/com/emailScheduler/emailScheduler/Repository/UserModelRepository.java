package com.emailScheduler.emailScheduler.Repository;

import com.emailScheduler.emailScheduler.Model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserModelRepository extends MongoRepository<UserModel, String> {
}
