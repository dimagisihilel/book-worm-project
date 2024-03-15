package lk.ijse.bo.custom.boImpl;

import lk.ijse.bo.custom.TransactionBo;
import lk.ijse.dao.custom.TransactionDao;
import lk.ijse.dao.custom.daoImpl.TransactionDaoImpl;
import lk.ijse.dto.TransactionDto;
import lk.ijse.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionBoImpl implements TransactionBo {
    private TransactionDao transactionDao = new TransactionDaoImpl();

}
