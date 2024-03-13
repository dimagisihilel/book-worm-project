package lk.ijse.dao.custom;

import lk.ijse.entity.User;
import org.hibernate.Session;

import java.sql.SQLException;

public interface UserDao {
    void addUser(User user, Session session) throws SQLException;
}
