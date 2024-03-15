package lk.ijse.dao;

import lk.ijse.dao.custom.daoImpl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        BOOK, TRANSACTION, USER, BRANCH, ADMIN
    }
    public SuperDao getDAO(DAOTypes daoType) {
        switch (daoType) {
            case BOOK:
                //return new BookDaoImpl();
            case TRANSACTION:
                //return new TransactionDaoImpl();
            case USER:
                //return new UserDaoImpl();
            case BRANCH:
                //return new BranchDaoImpl();
            case ADMIN:
                //return new AdminDaoImpl();
            default:
                return null;
        }
    }
}
