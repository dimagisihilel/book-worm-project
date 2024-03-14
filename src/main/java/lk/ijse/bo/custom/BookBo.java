package lk.ijse.bo.custom;

import lk.ijse.dto.BookDto;

import java.util.List;

public interface BookBo {
    void addBook(BookDto bookDto);
    void updateBook(BookDto bookDto);
    void deleteBook(int bookId);
    BookDto getBook(int bookId);
    List<BookDto> getAllBooks();

}
