package lk.ijse.dao.custom;

import lk.ijse.entity.Branch;
import org.hibernate.Session;

import java.util.List;

public interface BranchDao {

    void addBranch(Branch branch, Session session);

    List<Branch> getAllBranches(Session session);

    Branch getBranchById(int branchId, Session session);

    void updateBranch(Branch existingBranch, Session session);
}
