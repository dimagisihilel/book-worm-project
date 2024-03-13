package lk.ijse.bo.custom.boImpl;

import lk.ijse.bo.custom.UserBo;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AdminDao;
import lk.ijse.dao.custom.UserDao;
import lk.ijse.dao.custom.daoImpl.AdminDaoImpl;
import lk.ijse.dao.custom.daoImpl.UserDaoImpl;
import lk.ijse.dto.AdminDto;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.Admin;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class UserBoImpl implements UserBo {

    private UserDao userDao = new UserDaoImpl();
    FactoryConfiguration factory = FactoryConfiguration.getInstance();

    @Override
    public UserDto addUser(UserDto userDto) throws SQLException {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            userDao.addUser(new User( userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getPassword()),session);
            transaction.commit();
            return userDto ;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public UserDto loginUser(String email, String password) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = userDao.getUserByEmail(email, session);
            if (user != null && user.getPassword().equals(password)) {
                // Login successful, return the user DTO
                return new UserDto(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
            } else {
                // Login failed, return null
                return null;
            }
        } finally {
            transaction.commit();
            session.close();
        }
    }
}
