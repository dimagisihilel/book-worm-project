package lk.ijse.bo.custom.boImpl;

import lk.ijse.bo.custom.BookBo;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.BookDao;
import lk.ijse.dao.custom.daoImpl.BookDaoImpl;
import lk.ijse.dto.BookDto;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class BookBoImpl implements BookBo {


    FactoryConfiguration factory = FactoryConfiguration.getInstance();
    BookDao dao =  new BookDaoImpl();


    @Override
    public void addBook(BookDto bookDto) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        ModelMapper mapper = new ModelMapper();

        try {
            Book map = mapper.map(bookDto, Book.class);
            Branch branch = new Branch();
            map.setBranch(branch);
            branch.setBranchId(bookDto.getBranchId());
            session.detach(branch);
            dao.add(map, session);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            throw e;

        }finally {
            session.close();
        }
    }

    @Override
    public void updateBook(BookDto bookDto) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        ModelMapper mapper = new ModelMapper();

        try {
            Book map = mapper.map(bookDto, Book.class);
            Branch branch = new Branch();
            map.setBranch(branch);
            branch.setBranchId(bookDto.getBranchId());
            session.detach(branch);
            dao.update(map, session);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            throw e;

        }finally {
            session.close();
        }

    }

    @Override
    public void deleteBook(int bookId) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            dao.delete(bookId, session);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

    @Override
    public BookDto getBook(int bookId) {
        return null;
    }

    @Override
    public List<BookDto> getAllBooks() {
        Session session = factory.getSession();
        List<BookDto> list = new ArrayList<>();
        try(session) {
            List<Book> all = dao.getAll(session);
            ModelMapper mapper = new ModelMapper();
            for (Book book : all) {
                BookDto map = mapper.map(book, BookDto.class);
                map.setBranchId(book.getBranch().getBranchId());
                list.add(map);
            }
            return list;
        }
    }
}
