package com.company.PriorityQueue.Test;

import com.company.PriorityQueue.Model.Library.Book;
import com.company.PriorityQueue.Model.Library.Librarian;
import com.company.PriorityQueue.Model.Library.Library;
import com.company.PriorityQueue.Model.Person.Person;
import com.company.PriorityQueue.Model.Person.Teacher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibrarianTest {

    @Test
    void addBookToShelf() throws Exception {
        Librarian librarian = Library.getLibrarian();
        librarian.addABookToShelf(new Book("electronic circuit", 10));
        assertEquals(true, librarian.getShelf().containsKey("electronic circuit"));
    }

    @Test
    void giveABookOut() throws Exception {
        Librarian librarian = Library.getLibrarian();
        librarian.addABookToShelf(new Book("java fundamentals", 5));
        Person teacher = new Teacher("teacher");
        teacher.requestBook(teacher, "java fundamentals");
        assertEquals(true, librarian.acceptRequest(teacher, "java fundamentals"));
        librarian.processRequests();
        assertEquals(4, librarian.getShelf().get("java fundamentals"));

    }

    @Test
    void checkABookQuantityOnShelf() throws Exception {
        Librarian librarian = Library.getLibrarian();
        librarian.addABookToShelf(new Book("digital signal processing", 15));
        assertEquals(15, librarian.getShelf().get("digital signal processing"));
    }

    @Test
    void getShelf() {

    }

    @Test
    void acceptRequest() throws Exception {
        Librarian librarian = Library.getLibrarian();
        librarian.addABookToShelf(new Book("effective biology", 5));
        Person teacher = new Teacher("teacher");
        teacher.requestBook(teacher, "effective biology");
        assertEquals(true, librarian.acceptRequest(teacher, "effective biology"));

    }

    @Test
    void processRequests() {
    }
}