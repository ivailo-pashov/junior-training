package com.epam.junx.streams.upsa.domain;

import java.util.Collections;
import java.util.Set;

public class Employee {

    private final long id;
    private String firstName;
    private String lastName;
    private Set<Skill> skills;

    /**
     * if this is empty, then assume the employee is not managing anyone
     */
    private Set<Employee> subordinates = Collections.emptySet();
    private Role role;
    private Title title;
    private int yearsOfExperience;

    public Employee(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Skill> getSkills() {
        return skills == null ? Collections.emptySet() : Collections.unmodifiableSet(skills);
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Employee> getSubordinates() {
        return subordinates == null ? Collections.emptySet() : Collections.unmodifiableSet(subordinates);
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public String toString() {
        return "Employee{" + id + "=" + fullName() + '}';
    }
}
