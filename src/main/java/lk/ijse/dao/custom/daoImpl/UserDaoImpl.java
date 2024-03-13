package lk.ijse.dao.custom.daoImpl;

import lk.ijse.dao.custom.UserDao;
import lk.ijse.entity.Admin;
import lk.ijse.entity.User;
import org.hibernate.Session;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {


    @Override
    public void addUser(User user, Session session) throws SQLException {
        session.save(user);

    }
}
