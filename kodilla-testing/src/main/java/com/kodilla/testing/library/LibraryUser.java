package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryUser {
    private String firstName;
    private String lastName;
    private String peselId;
    private List<Book> rentedBooks = new ArrayList<>();

    public LibraryUser(String firstName, String lastName, String peselId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselId = peselId;
    }

    public void addRentedBook(Book rentedBook) {
        rentedBooks.add(rentedBook);
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPeselId() {
        return peselId;
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", peselId='" + peselId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getPeselId(), that.getPeselId());
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + peselId.hashCode();
        return result;
    }
}
