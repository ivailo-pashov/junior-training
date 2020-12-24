package com.epam.junx.streams.upsa.query;

import com.epam.junx.streams.upsa.data.EmployeesProvider;
import com.epam.junx.streams.upsa.domain.Employee;
import com.epam.junx.streams.upsa.domain.Role;
import com.epam.junx.streams.upsa.domain.Title;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class EmployeeService {

    //use provider to implement all methods
    private final EmployeesProvider provider;

    public EmployeeService(EmployeesProvider provider) {
        this.provider = provider;
    }

    /**
     * @return all employees with more than years of experience provided as parameter
     */
    public List<Employee> findAllEmployeesWithExperienceGreaterThan(int yearsOfExperience) {
        return Collections.emptyList(); //TODO implementation
    }

    /**
     * @return all unique last names of employees sorted by name in ascending order
     */
    public List<Employee> findAllEmployeesUniqueLastNames(int yearsOfExperience) {
        return Collections.emptyList(); //TODO implementation
    }

    /**
     * Find all unique first names for all Junior employees
     */
    public List<String> findAllJuniorEmployeesUniqueFirstNames() {
        return Collections.emptyList(); //TODO implementation
    }

    /**
     * @return full names of top employees based on topCount parameter sorting them by title (starting with most senior
     * ones) and then by years of experience (starting with most experienced)
     */
    public List<String> findTopExperiencedEmployees(int topCount) {
        return Collections.emptyList(); //TODO implementation
    }

    /**
     * @return all subordinates of the provided employees
     */
    public List<String> findAllSubordinates(List<Employee> employees) {
        return Collections.emptyList(); //TODO implementation
    }

    /**
     * @return the manager with the most skilled team (summing up all skills years); only direct subordinates should be
     * considered. Return the unit manager
     */
    public Employee findMostSkilledUnit() {
        return null; //TODO implementation
    }

    /**
     * @param skill - desired skill; cannot be blank
     * @param title - desired employee title; if null do not consider the title
     * @param role  - desired employee role; if null do not consider the role
     * @return the average experience in a particular skill for employees; Skip developers who do not have related
     * experience or who do not have the corresponding title or role
     */
    public double findAverageExperienceForEmployees(String skill, Title title, Role role) {
        return 0; //TODO implementation
    }

    /**
     * @return For every skill possessed by at least one of the employees, find how many employees are practicing this
     * skill
     */
    public Map<String, Integer> findSkillPracticeCount() {
        return Collections.emptyMap(); //TODO implementation
    }

    /**
     * @return For every skill possessed by at least one of the employees, find the standard deviation of the years of
     * experience https://en.wikipedia.org/wiki/Standard_deviation
     */
    public Map<String, Double> findYearsOfExperienceStandardDeviationBySkill() {
        return Collections.emptyMap(); //TODO implementation
    }

    /**
     * @return For every team (defined by its manager) find the total years of experience for all of employees' skills
     */
    public Map<Employee, Integer> findTotalSkillsYearsPerTeam() {
        return Collections.emptyMap(); //TODO implementation
    }

    /**
     * @return For every skill possessed by at least one of the employees, find the most skilled one (measured in years
     * of experience).
     */
    public Map<String, Employee> findMostSkilledEmployeePerSkill() {
        return Collections.emptyMap(); //TODO implementation
    }

    /**
     * @return the full name of the employee who is directly managing most employees
     */
    public String findManagerWithMostDirectSubordinates() {
        return null; //TODO implementation
    }

    /**
     * @return the full name of the employee who is managing most employees (both direct and indirect)
     */
    public String findManagerWithMostTransitiveSubordinates() {
        return null; //TODO implementation
    }

    /**
     * @return true if no Lead Manager exists among all employees
     */
    public boolean verifyNoLeadManagerExists() {
        return false; //TODO implementation
    }

    /**
     * @return the ratio between Developers and Test Engineers inside the company
     */
    public double getRatioBetweenDevelopersAndTestEngineers() {
        return 1; //TODO implementation
    }
}
