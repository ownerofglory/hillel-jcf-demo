package ua.ithillel.jcf.model;

import java.util.Objects;

public class Employee extends Human {
    private String job;
    public Employee(String name, int age) {
        super(name, age);
    }

    public Employee(String name, int age, String job) {
        super(name, age);
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee human = (Employee) o;
        return age == human.age && Objects.equals(name, human.name)
                && Objects.equals(job, job);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
