package lk.ijse.bo.custom.boImpl;

import lk.ijse.bo.custom.BranchBo;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AdminDao;
import lk.ijse.dao.custom.BranchDao;
import lk.ijse.dao.custom.daoImpl.AdminDaoImpl;
import lk.ijse.dao.custom.daoImpl.BranchDaoImpl;
import lk.ijse.dto.BranchDto;
import lk.ijse.entity.Admin;
import lk.ijse.entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class BranchBoImpl implements BranchBo {
    private BranchDao branchDao = new BranchDaoImpl();
    FactoryConfiguration factory = FactoryConfiguration.getInstance();

    @Override
    public BranchDto addBranch(BranchDto branchDto) throws SQLException {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Admin admin = new Admin();
            admin.setAdminId(branchDto.getAdminId());
            session.detach(admin);
            branchDao.addBranch(new Branch(branchDto.getBranchName(), branchDto.getBranchAddress(), branchDto.getBranchContact(), admin), session);
            System.out.println("Branch added successfully");
            transaction.commit();
            return branchDto;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<BranchDto> getAllBranches() throws SQLException {
        return null;
    }
}
