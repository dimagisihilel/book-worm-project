package lk.ijse.bo.custom;

import lk.ijse.dto.BranchDto;

import java.sql.SQLException;

public interface BranchBo {
    BranchDto addBranch(BranchDto branchDto) throws SQLException;
}
