package ru.kulbaka.libraryCatalogue.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class Person {

    private int personId; //добавить валидацию и паттерн ФИО

    @Pattern(regexp = "[А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+", message = "Имя должно быть в формате: Фамилия Имя Отчество")
    private String fullName;

    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
    private int birthYear;

    public Person() {
    }

    public Person(int personId, String fullName, int birthYear) {
        this.personId = personId;
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
