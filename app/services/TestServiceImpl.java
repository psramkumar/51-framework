package services;

import daos.TestDao;
import daos.UserProfile;
import daos.UserProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by saeed on 9/March/15 AD.
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private UserProfileDao userProfileDao;

    @Override
    public void echo(String message) {
        userProfileDao.count();
        UserProfile u = userProfileDao.findOne("5708c7fdeffb132c03586513");
        System.out.println("u = " + u);
        u.setName(UUID.randomUUID().toString());
        userProfileDao.save(u);
        testDao.echo(message);
    }
}
