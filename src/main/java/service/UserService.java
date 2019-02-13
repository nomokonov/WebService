package service;

import service.dao.UsersDAO;
import service.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class UserService {
    private  final SessionFactory sessionFactory;
    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
//
//    public User getUser(long id) throws DBException {
//        try {
//            Session session = sessionFactory.openSession();
//            UsersDAO dao = new UsersDAO(session);
//            User dataSet = dao.get(id);
//            session.close();
//            return dataSet;
//        } catch (HibernateException e) {
//            throw new DBException(e);
//        }
//    }

    public User getUser(String name) {
        try {
            Session session = sessionFactory.openSession();
            UsersDAO dao = new UsersDAO(session);
            User dataSet = dao.get(name);
            session.close();
            return dataSet;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public long addUser(User  user) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            UsersDAO dao = new UsersDAO(session);
            long id = dao.insertUser(user);
            transaction.commit();
            session.close();
            return id;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
