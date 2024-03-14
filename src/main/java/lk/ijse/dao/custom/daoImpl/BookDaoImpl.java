package lk.ijse.dao.custom.daoImpl;

import lk.ijse.dao.custom.BookDao;
import lk.ijse.entity.Book;
import org.hibernate.Session;

import java.util.List;

public class BookDaoImpl implements BookDao {

    @Override
    public Book add(Book book, Session session) {
        session.persist(book);
        return book;
    }

    @Override
    public void update(Book book, Session session) {
        session.merge(book);
    }

    @Override
    public void delete(Integer integer, Session session) {
        session.createQuery("delete from Book where bookId = :id").setParameter("id", integer).executeUpdate();
    }

    @Override
    public Book get(Integer integer, Session session) {
        return session.get(Book.class, integer);
    }

    @Override
    public List<Book> getAll(Session session) {
        return session.createQuery("from Book",Book.class).list();
    }
}
