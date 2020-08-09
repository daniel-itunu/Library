package com.company.PriorityQueue.Model.Library;

import com.company.PriorityQueue.Model.Person.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * class Librarian model a librarian
 */
public final class Librarian {
    private static Map<Person, String> personRequestMap;

    public Librarian() {
        personRequestMap = new HashMap<>();
    }

    /**
     * adds a book to the shelf
     * @return true if a book is successfully added to shelf
     */
    public static final boolean addABookToShelf(Book book) throws Exception {
        if(Library.addABookToShelf(book) != true){
            throw new Exception("failed to add "+book.getTitle()+"to shelf");
        }
        return true;
    }

    /**
     * Give out a book from shelf to requested users
     * @return String confirming details of person and book title given out
     */
    public static final boolean giveABookOut(Person person, String bookName) throws Exception {
        if( Library.getABookFromShelf(person, bookName) != true){
            throw new Exception("failed to give "+bookName+"out");
        }
        return true;
    }

    /**
     * checks quqntity of a particular book left on the shelf
     * @return Integer quanity of the book
     */
    public final String checkABookQuantityOnShelf(String bookName) {
        return "Quantity of "+bookName+" is on the shelf "+Library.checkABookQuantityOnShelf(bookName);
    }

    /**
     * Gets shelf instance from library class.
     * @return shelf instance.
     */
    public final Map<String, Integer> getShelf(){
        return Library.getShelf();
    }

    /**
     * Accepts book request of users, maps
     * each user to their book request name.
     * @return true if request succeffuly accepted.
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
                    super.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.run();
        return true;
    }

    /**
     * process all requests accepted while queue isn't empty.
     * @return true if request processed.
     */
    public final boolean processRequests() throws Exception {
        while (!Library.getPersonPriorityQueue().isEmpty()){
            if(giveABookOut(Library.getPersonPriorityQueue().remove(),
                    personRequestMap.get(Library.getPersonPriorityQueue().remove())) != true){
                throw new Exception("failed to process requests");
            }
        }
        return true;
    }
}
