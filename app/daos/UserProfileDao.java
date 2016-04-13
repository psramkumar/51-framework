package daos;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pillai on 4/9/16.
 */
public interface UserProfileDao extends MongoRepository<UserProfile, String> {
}
