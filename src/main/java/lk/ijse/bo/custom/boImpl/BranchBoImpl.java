package lk.ijse.bo.custom.boImpl;

import lk.ijse.bo.custom.BranchBo;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AdminDao;
import lk.ijse.dao.custom.BranchDao;
import lk.ijse.dao.custom.daoImpl.AdminDaoImpl;
import lk.ijse.dao.custom.daoImpl.BranchDaoImpl;
import lk.ijse.dto.BranchDto;
import lk.ijse.entity.Admin;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.ArrayList;
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
        List<BranchDto> list = new ArrayList<>();
       /* List<BranchDto> branchDtos = new ArrayList<>();
        try {
            List<Branch> branches = branchDao.getAllBranches();
            for (Branch branch : branches) {
                branchDtos.add(convertBranchToDto(branch));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return branchDtos;*/
        ModelMapper mapper = new ModelMapper();
        Session session = factory.getSession();
        try {
            List<Branch> allBranches = branchDao.getAllBranches(session);

            for (Branch entity : allBranches) {
                BranchDto map = mapper.map(entity, BranchDto.class);
                list.add(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }


        return list;
    }

    @Override
    public void updateBranch(BranchDto branchDto) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Branch existingBranch = branchDao.getBranchById(branchDto.getBranchId(), session);
            session.detach(existingBranch.getAdmin());

            existingBranch.setBranchName(branchDto.getBranchName());
            existingBranch.setAddress(branchDto.getBranchAddress());
            existingBranch.setContact(branchDto.getBranchContact());

            // Update the branch entity in the database
            branchDao.updateBranch(existingBranch, session);

            System.out.println("Branch updated successfully");
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
