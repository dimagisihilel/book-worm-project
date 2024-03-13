package lk.ijse.dao.custom;

import lk.ijse.entity.Branch;
import org.hibernate.Session;

public interface BranchDao {

    void addBranch(Branch branch, Session session);
}
