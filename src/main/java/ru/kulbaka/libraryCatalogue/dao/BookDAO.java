package ru.kulbaka.libraryCatalogue.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kulbaka.libraryCatalogue.models.Book;
import ru.kulbaka.libraryCatalogue.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Book WHERE bookId=?", new BeanPropertyRowMapper<>(Book.class), id);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(personId, name, author, creationYear) VALUES(?, ?, ?, ?)", null, book.getName(), book.getAuthor(), book.getCreationYear());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET name=?, author=?, creationYear=? WHERE bookId=?", updatedBook.getName(), updatedBook.getAuthor(), updatedBook.getCreationYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE bookId=?", id);
    }

    public List<Book> orderedBooks(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE personId=?", new BeanPropertyRowMapper<>(Book.class), id);
    }

    public Optional<Person> isOrderedByPerson(int bookId) {
        return jdbcTemplate.query("SELECT Person.personId, fullname, birthYear FROM Person JOIN Book ON Person.personId = Book.personID WHERE bookId=?", new Object[] {bookId}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void assignABook(int bookId, int personId) {
        jdbcTemplate.update("UPDATE Book SET PersonId=? WHERE bookId=?", personId, bookId);
    }

    public void release(int bookId) {
        jdbcTemplate.update("UPDATE Book SET personId=null WHERE bookId=?", bookId);
    }
}
