package lk.ijse.bo.custom;

import lk.ijse.dto.TransactionDto;
import lk.ijse.tm.NotReturnedTM;

import java.util.List;

public interface BorrowBookRecordBo {
    void borrowBook(TransactionDto transactionDto);
    List<NotReturnedTM> getNotReturnedListByUserId(int userId);
    void returnBook(NotReturnedTM obj);
}
