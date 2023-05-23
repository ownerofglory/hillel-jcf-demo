package ua.ithillel.jcf;

import java.util.ArrayList;
import java.util.List;

public class Person implements Cloneable {
    private String name;
    private List<Person> friends;

    @Override
    public Person clone() {
        Person copy = new Person();
        copy.name = name;
        copy.friends = new ArrayList<>();
        return copy;
    }

    public String getName() {
        return name;
    }
}
