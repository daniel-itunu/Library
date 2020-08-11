package com.company.PriorityQueue;

import com.company.PriorityQueue.Model.Library.Book;
import com.company.PriorityQueue.Model.Library.Librarian;
import com.company.PriorityQueue.Model.Library.Library;
import com.company.PriorityQueue.Model.Person.JuniorStudent;
import com.company.PriorityQueue.Model.Person.Person;
import com.company.PriorityQueue.Model.Person.SeniorStudent;
import com.company.PriorityQueue.Model.Person.Teacher;

public class MainPriorityQueue {

    public static void main(String[] args) throws Exception {
        //liberian adds/populate books to shelf in the library
        Librarian librarian = Library.getLibrarian();

        //librarian add 3 books
        librarian.addABookToShelf(new Book("8085 Architecture",1 ));
        librarian.addABookToShelf(new Book("Electronic circuit",30));
        librarian.addABookToShelf(new Book("Digital signal processing",5));
        System.out.println("\n");

        //check the quantities of books added above to shelf
        System.out.println(librarian.checkABookQuantityOnShelf("8085 Architecture"));//10
        System.out.println(librarian.checkABookQuantityOnShelf("Electronic circuit"));//30
        System.out.println(librarian.checkABookQuantityOnShelf("Digital signal processing"));//5
        System.out.println("\n");

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
        System.out.print("Accepting requests");
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

