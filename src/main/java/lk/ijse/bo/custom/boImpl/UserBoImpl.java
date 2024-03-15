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

    @Override
    public UserDto getUserById(int activeUserId) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = userDao.getUserById(activeUserId, session);
            if (user != null) {
                // User found, return the user DTO
                return new UserDto(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
            } else {
                // User not found, return null
                return null;
            }
        } finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public UserDto updateUser(UserDto updatedUser) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            // Get the existing user entity from the database
            User existingUser = userDao.getUserById(updatedUser.getUserId(), session);

            if (existingUser != null) {
                // Update the existing user entity with the new data
                existingUser.setFirstName(updatedUser.getFirstName());
                existingUser.setLastName(updatedUser.getLastName());
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setPassword(updatedUser.getPassword());

                // Update the user in the database
                userDao.updateUser(existingUser, session);
                transaction.commit();
                return updatedUser;
            } else {
                return null;
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
