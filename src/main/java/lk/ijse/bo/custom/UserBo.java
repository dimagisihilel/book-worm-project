package lk.ijse.bo.custom;

import lk.ijse.dto.AdminDto;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public interface UserBo {
    UserDto addUser(UserDto userDto) throws SQLException;
}
