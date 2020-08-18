package com.company.PriorityQueue.Comparator;

import com.company.PriorityQueue.Model.Person.Person;

import java.util.Comparator;

/**
 * PersonComparator class compares the priority of different
 * persons coming to the library.
 */
public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getPRIORITY() < p2.getPRIORITY()) {
            return 1;
        } else if (p1.getPRIORITY() > p2.getPRIORITY()) {
            return -1;
        }
        return 0;
    }
}
