package com.company.PriorityQueue.Model.Library;

import com.company.PriorityQueue.Comparator.PersonComparator;
import com.company.PriorityQueue.Model.Person.Person;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * class library models a typical library
 */
public final class Library {
    //a typical library has a librarian, book shelf and queue of book borrowers.
    private static final Librarian librarian = new Librarian();
    private static final HashMap<String, Integer> shelf = new HashMap();
    private static final PriorityQueue<Person> personPriorityQueue = new PriorityQueue<>(new PersonComparator());

    /**
     * populates/add a particular book to the library shelf.
     *
     * @param book- the book to be added to the library shelf.
     * @return String: if a book is successfully added to the shelf
     * and its present quantity
     */
    static final boolean addABookToShelf(Book book) throws Exception {
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
     * @return String: if a book is successfully given,
     * decrease its quantity by 1 and not found if book doesn't exist on the shelf.
     */
    static final boolean getABookFromShelf(Person person, String bookName) throws Exception {
        //if shelf contains the book wanted, go ahead,
        //get book and deduct 1 from its quantity
        //if book isn't available, return not found.
        if (shelf.containsKey(bookName)) {
            shelf.put(bookName, shelf.get(bookName) - 1);
            new Thread() {
                @Override
                public void run() {
                    System.out.print("\nPROCESSED REQUEST: Book->" + bookName + " given to " + person.getName() + ". " +
                            "Quantity of " + bookName + " left on shelf is " + shelf.get(bookName));
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.run();
            return true;
        }
        throw new Exception("book " + bookName + " not found");
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
    public static final PriorityQueue<Person> getPersonPriorityQueue() {
        return personPriorityQueue;
    }
}

