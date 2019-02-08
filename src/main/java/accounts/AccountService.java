package accounts;

import dbService.DBException;
import dbService.dao.UsersDAO;
import dbService.dataSets.UsersDataSet;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {
    private final UsersDAO usersDAO;
    private final Map<String, UsersDataSet> sessionIdToProfile;
    private final SessionFactory sessionFactory;

    public AccountService() {
         this.usersDAO = new UsersDAO();
        sessionIdToProfile = new HashMap<>();
        sessionFactory = createSessionFactory(configuration);
    }

    public void addNewUser(String name) {
//        loginToProfile.put(userProfile.getLogin(), userProfile);
        try {

            long userId = usersDAO.insertUser(name);
            System.out.println("Added user id: " + userId);
            UsersDataSet dataSet = usersDAO.get(userId);
            System.out.println("User data set: " + dataSet);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public UsersDataSet get(String login) {
        return usersDAO.get(login);
    }

    public UsersDataSet getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, UsersDataSet userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }


    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
