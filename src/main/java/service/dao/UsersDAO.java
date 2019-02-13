package service.dao;

import service.domain.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public User get(long id) throws HibernateException {
        return (User) session.get(User.class, id);
    }
    public User get(String name) throws HibernateException {
        String hql = "FROM User where name = :paramName";
        Query query = session.createQuery(hql);
        query.setParameter("paramName", name);
        List<User> users = query.list();
        return users.get(0);
    }
    public long getUserId(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(User.class);
        return ((User) criteria.add(Restrictions.eq("name", name)).uniqueResult()).getId();
    }

    public long insertUser(User user) throws HibernateException {
        return (Long) session.save(user);
    }
}
