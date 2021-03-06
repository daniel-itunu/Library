package com.company.Queue.Model.Library;

import com.company.Queue.Model.Person.Person;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * class library models a typical library
 */
public final class Library {
    //a typical library has a librarian, book shelf and queue of book borrowers.
    private static final Librarian librarian = new Librarian();
    private static final HashMap<String, Integer> shelf = new HashMap();
    private static final Queue<Person> personQueue = new LinkedList<>();

    /**
     * populates/add a particular book to the library shelf.
     *
     * @param book- the book to be added to the library shelf.
     * @return String: if a book is successfully added to the shelf
     * and its present quantity
     */
    static final boolean addBookToShelf(Book book) throws Exception {
        //if shelf does not contain present book to be added
        //go ahead and add the book to shelf.
        //if book is already present on shelf, increase its quantity.
        if (!shelf.containsKey(book.getTitle())) {
            getShelf().put(book.getTitle(), book.getQuantity());
            System.out.println("successfully added " + book.getTitle() + " to shelf. " +
                    "Quantity of book-> " + book.getTitle() + " is " + shelf.get(book.getTitle()));
            return true;
        }
        if (shelf.containsKey(book.getTitle())) {
            shelf.put(book.getTitle(), book.getQuantity() + shelf.get(book.getTitle()));
            System.out.println("successfully added " + book.getTitle() + " to shelf. " +
                    "Quantity of book->" + book.getTitle() + " is " + shelf.get(book.getTitle()));
            return true;
        }
        throw new Exception("failed to add book" + book.getTitle() + " to shelf");
    }

    /**
     * gets a particular book from the library shelf.
     *
     * @param person-   the person book is to be given to.
     * @param bookName- the name of book to be given out.
     * @return String: if a book is successfully given, decrease its
     * quantity by 1 and not found if book doesn't exist on the shelf.
     * @throws Exception if empty name or empty book name is being passed into request.
     */
    static final String getABookFromShelf(Person person, String bookName) throws Exception {
        //if shelf contains the book wanted, go ahead,
        //get book and deduct 1 from its quantity
        //if book isn't available, return not found.
        if (shelf.containsKey(bookName)) {
            shelf.put(bookName, shelf.get(bookName) - 1);
            if (shelf.get(bookName) < 0) {
                System.out.print("\n" + bookName + " taken");
                return bookName + " taken";
            }
            if (person.getName().isEmpty() || bookName.isEmpty()) {
                throw new Exception("unknown person/empty name or book name. provide name/book name");
            }
            new Thread() {
                @Override
                public void run() {
                    System.out.print("\nPROCESSED REQUEST: Book->" + bookName + " given to " + person.getName() + ". " +
                            "Quantity of " + bookName + " left on shelf is " + shelf.get(bookName));
                    try {
                        sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.run();
            return "successfully taken";
        }
        throw new Exception("book " + bookName + " not found/incorrect name/empty request name");
    }

    /**
     * checks quantity of a particular book remaining on the shelf.
     *
     * @param bookName- the name of book to lookup on the shelf.
     * @return Integer: quantity of that book remaining on shelf.
     */
    static final Integer checkABookQuantityOnShelf(String bookName) {
        return shelf.get(bookName);
    }

    /**
     * Gets singleton librarian instance
     *
     * @return librarian instance
     */
    public static final Librarian getLibrarian() {
        return librarian;
    }

    /**
     * Gets singleton shelf instance
     *
     * @return the shelf books are kept in.
     */
    public static final HashMap<String, Integer> getShelf() {
        return shelf;
    }

    /**
     * Gets singleton prioritised queue of users.
     *
     * @return prioritised queue of users.
     */
    public static final Queue<Person> getPersonQueue() {
        return personQueue;
    }
}


