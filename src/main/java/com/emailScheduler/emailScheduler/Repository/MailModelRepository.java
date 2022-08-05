package com.emailScheduler.emailScheduler.Repository;

import com.emailScheduler.emailScheduler.Model.MailModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MailModelRepository extends MongoRepository<MailModel, String> {
}
