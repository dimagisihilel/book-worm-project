package lk.ijse.bo.custom;

import lk.ijse.dto.BranchDto;

import java.sql.SQLException;
import java.util.List;

public interface BranchBo {
    BranchDto addBranch(BranchDto branchDto) throws SQLException;

    List<BranchDto> getAllBranches() throws SQLException;
}
