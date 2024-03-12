package lk.ijse.bo.custom;

import lk.ijse.dto.AdminDto;

import java.sql.SQLException;

public interface AdminBo {

    AdminDto addAdmin(AdminDto adminDto) throws SQLException;

    AdminDto loginAdmin(String email, String password);
}
