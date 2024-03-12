package lk.ijse.bo.custom.boImpl;

import lk.ijse.bo.custom.AdminBo;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AdminDao;
import lk.ijse.dao.custom.daoImpl.AdminDaoImpl;
import lk.ijse.dto.AdminDto;
import lk.ijse.entity.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class AdminBoImpl implements AdminBo {
    private AdminDao adminDao = new AdminDaoImpl();
    FactoryConfiguration factory = FactoryConfiguration.getInstance();

    public AdminDto addAdmin(AdminDto adminDto) throws SQLException {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            adminDao.addAdmin(new Admin( adminDto.getFirstName(), adminDto.getLastName(), adminDto.getEmail(), adminDto.getPassword()),session);
            transaction.commit();
            return adminDto ;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public AdminDto loginAdmin(String email, String password) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Admin admin = adminDao.getAdminByEmail(email, session);
            if (admin != null && admin.getPassword().equals(password)) {
                // Login successful, return the admin DTO
                return new AdminDto(admin.getAdminId(), admin.getFirstName(), admin.getLastName(), admin.getEmail(), admin.getPassword());
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
