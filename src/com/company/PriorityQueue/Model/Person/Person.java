package com.company.PriorityQueue.Model.Person;

import com.company.PriorityQueue.Model.Library.Librarian;
import com.company.PriorityQueue.Model.Library.Library;

public abstract class Person {
    private String name;
    private Integer PRIORITY;

    public Person(String name, Integer PRIORITY) {
        this.name = name;
        this.PRIORITY = PRIORITY;
    }

    public Integer getPRIORITY() {
        return PRIORITY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean requestBook(Person person, String bookName) throws Exception {
        if(!Library.getLibrarian().getShelf().containsKey(bookName)){
            throw new Exception(bookName+" isn't available on shelf");
        }
        if(!person.getName().isEmpty()&&!bookName.isEmpty()){
            return Librarian.acceptRequest(person, bookName);
        }
        throw new Exception("<Person> name or <bookName> is empty");
    }
}

