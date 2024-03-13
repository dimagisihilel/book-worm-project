package lk.ijse.dao.custom.daoImpl;

import lk.ijse.dao.custom.BranchDao;
import lk.ijse.entity.Branch;
import org.hibernate.Session;

public class BranchDaoImpl implements BranchDao {

    @Override
    public void addBranch(Branch branch, Session session) {
        session.save(branch);
    }
}
