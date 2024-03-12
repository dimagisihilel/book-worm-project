package lk.ijse.dao.custom.daoImpl;
import lk.ijse.dao.custom.AdminDao;
import lk.ijse.entity.Admin;
import org.hibernate.Session;

import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    public void addAdmin(Admin admin, Session session) throws SQLException {
        session.save(admin);
    }

}
