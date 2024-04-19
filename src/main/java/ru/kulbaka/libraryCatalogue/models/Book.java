package ru.kulbaka.libraryCatalogue.models;

public class Book {

    private int id;

    private String name;

    private String author;

    private int creationYear;

    public Book() {
    }

    public Book(int id, String name, int creationYear) {
        this.id = id;
        this.name = name;
        this.creationYear = creationYear;
    }

    public int getBookId() {
        return id;
    }

    public void setBookId(int id) {
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
