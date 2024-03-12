package lk.ijse.dao.custom;

import lk.ijse.entity.Admin;
import org.hibernate.Session;


import java.sql.SQLException;

public interface AdminDao {
    void addAdmin(Admin admin, Session session) throws SQLException;

    Admin getAdminByEmail(String email, Session session);
}
