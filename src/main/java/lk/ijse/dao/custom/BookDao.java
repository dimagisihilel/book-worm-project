package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDao;
import lk.ijse.entity.Book;
import org.hibernate.Session;

public interface BookDao extends CrudDao<Book, Integer> {
    public boolean updateAvailability(Session session,int bookId,String availability);
}
