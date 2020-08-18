package com.company.PriorityQueue.Model.Person;

import com.company.PriorityQueue.Model.Library.Librarian;

public abstract class Person {
    protected String name;
    protected Integer PRIORITY;

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
        return Librarian.acceptRequest(person, bookName);
    }

}