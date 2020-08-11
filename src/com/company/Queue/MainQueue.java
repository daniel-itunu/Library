package com.company.Queue;

import com.company.Queue.Model.Library.Book;
import com.company.Queue.Model.Library.Librarian;
import com.company.Queue.Model.Library.Library;
import com.company.Queue.Model.Person.JuniorStudent;
import com.company.Queue.Model.Person.Person;
import com.company.Queue.Model.Person.SeniorStudent;
import com.company.Queue.Model.Person.Teacher;

public class MainQueue {
    public static void main(String[] args) throws Exception {
        //liberian adds/populate books to shelf in the library
        Librarian librarian = Library.getLibrarian();

        //librarian add 3 books to shelf
        librarian.addBookToShelf(new Book("8085 Architecture",1 ));
        librarian.addBookToShelf(new Book("Electronic circuit",30));
        librarian.addBookToShelf(new Book("Digital signal processing",5));
        System.out.print("\n");

        //check the quantities of books added above to shelf
        System.out.println(librarian.checkABookQuantityOnShelf("8085 Architecture"));//10
        System.out.println(librarian.checkABookQuantityOnShelf("Electronic circuit"));//30
        System.out.println(librarian.checkABookQuantityOnShelf("Digital signal processing"));//5
        System.out.print("\n");

        //person objects who want to make request
        Person junior = new JuniorStudent("junior");
        Person senior = new SeniorStudent("senior");
        Person teacher = new Teacher("teacher");
        Person john = new JuniorStudent("john-junior");
        Person paul = new SeniorStudent("paul-senior");
        Person thomas = new Teacher("thomas-teacher");

        //person objects make their requests
        junior.requestBook(junior,"8085 Architecture");
        senior.requestBook(senior,"8085 Architecture");
        teacher.requestBook(teacher,"8085 Architecture");
        john.requestBook(john,"Electronic circuit");
        paul.requestBook(paul,"Electronic circuit");
        thomas.requestBook(thomas,"Digital signal processing");

        //librarian accepts requests
        System.out.print("ACCEPTING REQUESTS");
        librarian.acceptRequest(junior, "8085 Architecture");
        librarian.acceptRequest(senior, "8085 Architecture");
        librarian.acceptRequest(teacher, "8085 Architecture");
        librarian.acceptRequest(john, "Electronic circuit");
        librarian.acceptRequest(paul, "Electronic circuit");
        librarian.acceptRequest(thomas, "Digital signal processing");

        //librarian processes the requests made
        librarian.processRequests();

    }
}
