package lk.ijse.dao.custom.daoImpl;

import lk.ijse.dao.custom.UserDao;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {


    @Override
    public void addUser(User user, Session session) throws SQLException {
        session.save(user);

    }

    @Override
    public User getUserByEmail(String email, Session session) {
        // Query to get user by email
        Query<User> query = session.createQuery("FROM User WHERE email = :email", User.class);
        query.setParameter("email", email);
        return query.uniqueResult(); // Return the unique result or null if not found
    }

    @Override
    public User getUserById(int activeUserId, Session session) {
        // Query to get user by ID
        Query<User> query = session.createQuery("FROM User WHERE userId = :userId", User.class);
        query.setParameter("userId", activeUserId);
        return query.uniqueResult(); // Return the unique result or null if not found
    }

    @Override
    public void updateUser(User existingUser, Session session) {
        session.update(existingUser);
    }

}
