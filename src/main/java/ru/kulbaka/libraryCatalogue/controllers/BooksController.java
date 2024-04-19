package ru.kulbaka.libraryCatalogue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kulbaka.libraryCatalogue.dao.BookDAO;
import ru.kulbaka.libraryCatalogue.dao.PersonDAO;
import ru.kulbaka.libraryCatalogue.models.Book;
import ru.kulbaka.libraryCatalogue.models.Person;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookDAO bookDAO;

    private final PersonDAO personDAO;

    @Autowired
    public BooksController(BookDAO bookDAO, PersonDAO personDAO) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model, @ModelAttribute("personToAssign") Person person) {
        Book book = bookDAO.show(id);
        model.addAttribute("book", book);

        Optional<Person> bookOwner = bookDAO.isOrderedByPerson(book.getBookId());

        if (bookOwner.isPresent())
            model.addAttribute("person", bookOwner.get());
        else
            model.addAttribute("people", personDAO.index());

        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") Book book) {
        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.show(id));
        return "books/edit";
    }

    @PatchMapping({"/{id}"})
    public String update(@ModelAttribute("book") Book updatedBook, @PathVariable("id") int id) {
        bookDAO.update(id, updatedBook);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/assign")
    public String assign(@PathVariable("id") int bookId, @ModelAttribute("person") Person person) {
        bookDAO.assignABook(bookId, person.getPersonId());
        return "redirect:/books/" + bookId;
    }

    @PatchMapping("/{id}/release")
    public String release(@PathVariable("id") int bookId) {
        bookDAO.release(bookId);
        return "redirect:/books/" + bookId;
    }
}
