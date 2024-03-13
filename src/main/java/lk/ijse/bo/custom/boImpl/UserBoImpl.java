package lk.ijse.bo.custom.boImpl;

import lk.ijse.bo.custom.UserBo;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AdminDao;
import lk.ijse.dao.custom.UserDao;
import lk.ijse.dao.custom.daoImpl.AdminDaoImpl;
import lk.ijse.dao.custom.daoImpl.UserDaoImpl;
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
}
