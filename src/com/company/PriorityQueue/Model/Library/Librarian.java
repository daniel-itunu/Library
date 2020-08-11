package com.company.PriorityQueue.Model.Library;

import com.company.PriorityQueue.Model.Person.Person;
import java.util.HashMap;
import java.util.Map;

/**
 * class Librarian model a librarian
 */
public final class Librarian {
    private static Map<Person, String> personRequestMap = new HashMap<>();

    /**
     * Adds a book to the shelf
     * @param book the book to be addded to shelf.
     * @return true if a book is successfully added to shelf
     * @throws Exception if book cannot be added for any reason
     */
    public static final boolean addABookToShelf(Book book) throws Exception {
        if(Library.addBookToShelf(book) == false){
            throw new Exception("failed to add "+book.getTitle()+"to shelf");
        }
        return true;
    }

    /**
     * Give out a book from shelf to requested users
     * @param person the person to give book to.
     * @param bookName the book name of book to give out.
     * @return String confirming details of person and book title given out
     */
    public static String giveABookOut(Person person, String bookName) throws Exception {
       return Library.getABookFromShelf(person, bookName);
    }

    /**
     * checks quantity of a particular book left on the shelf.
     * @param bookName the name of book to check its quantity.
     * @return String the quantity of the book on the shelf.
     */
    public final String checkABookQuantityOnShelf(String bookName){
        return "Quantity of "+bookName+" on the shelf is "+Library.checkABookQuantityOnShelf(bookName);
    }

    /**
     * Accepts book request of users, maps each user to their book request name.
     * @param person the person to accept request from.
     * @param want the need/book name of person requesting.
     * @return true if request successfully accepted.
     * @throws Exception if request cannot be accepted for whatever reasons.
     */
    public static final boolean acceptRequest(Person person, String want) throws Exception {
        if( Library.getPersonPriorityQueue().add(person) != true){
            throw new Exception("Accept request failed");
        }
        personRequestMap.put(person, want);
        new Thread(){
            @Override
            public void run() {
                System.out.print(".....");
                try {
                    super.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.run();
        return true;
    }

    /**
     * process all requests accepted while queue isn't empty.
     * @throws Exception if requests cannot be processed.
     */
    public final void processRequests() throws Exception {
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.print("\nProcessing requests..................");
                    super.sleep(600);
                    System.out.print(".........................................");
                    super.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.run();
        while (!Library.getPersonPriorityQueue().isEmpty()) {
            giveABookOut(Library.getPersonPriorityQueue().remove(),
                personRequestMap.get(Library.getPersonPriorityQueue().remove()));
        }
    }

    /**
     * Gets shelf instance from library class.
     * @return shelf instance.
     */
    public final Map<String, Integer> getShelf(){
        return Library.getShelf();
    }

}
