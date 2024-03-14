package lk.ijse.dao.custom.daoImpl;

import lk.ijse.dao.custom.BranchDao;
import lk.ijse.entity.Branch;
import org.hibernate.Session;

import java.util.List;

public class BranchDaoImpl implements BranchDao {

    @Override
    public void addBranch(Branch branch, Session session) {
        session.save(branch);
    }

    @Override
    public List<Branch> getAllBranches(Session session) {
        return session.createQuery("from Branch", Branch.class).list();
    }
}
