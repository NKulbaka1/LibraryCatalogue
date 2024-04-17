package ru.kulbaka.libraryCatalogue.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kulbaka.libraryCatalogue.models.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE personId = ?", new BeanPropertyRowMapper<>(Person.class), id);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(fullName, birthYear) VALUES(?, ?)", person.getFullName(), person.getBirthYear());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET fullName=?, birthYear=? WHERE personId=?", updatedPerson.getFullName(), updatedPerson.getBirthYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE personId=?", id);
    }
}
