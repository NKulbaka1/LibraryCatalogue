package ru.kulbaka.libraryCatalogue.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Book {

    private int id;

    @NotEmpty(message = "Название не должно быть пустым")
    private String name;

    @Pattern(regexp = "[А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+", message = "Имя должно быть в формате: Фамилия Имя Отчество")
    private String author;

    @NotNull(message = "Год создания не должен быть пустым")
    private int creationYear;

    public Book() {
    }

    public Book(int id, String name, int creationYear) {
        this.id = id;
        this.name = name;
        this.creationYear = creationYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
