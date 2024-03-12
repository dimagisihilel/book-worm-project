package lk.ijse.dao.custom.daoImpl;
import lk.ijse.dao.custom.AdminDao;
import lk.ijse.entity.Admin;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    public void addAdmin(Admin admin, Session session) throws SQLException {
        session.save(admin);
    }

    @Override
    public Admin getAdminByEmail(String email, Session session) {
        // Query to get admin by email
        Query<Admin> query = session.createQuery("FROM Admin WHERE email = :email", Admin.class);
        query.setParameter("email", email);
        return query.uniqueResult(); // Return the unique result or null if not found
    }

}
