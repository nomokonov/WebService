package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

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
    private final DBService dbService;
    private final Map<String, UsersDataSet> sessionIdToProfile;

    public AccountService(DBService dbService) {
        this.dbService = dbService;
        sessionIdToProfile = new HashMap<>();
    }

    public void addNewUser(String name, String password) {
        try {
            dbService.addUser(name, password);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public UsersDataSet getUserByLogin(String login) {
        try {
            return dbService.getUser(login);
        } catch (DBException e) {
            e.printStackTrace();
        }
        return null;
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
}
