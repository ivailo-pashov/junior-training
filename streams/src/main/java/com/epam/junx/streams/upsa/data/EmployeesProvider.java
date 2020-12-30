package com.epam.junx.streams.upsa.data;

import com.epam.junx.streams.upsa.domain.Employee;
import java.util.List;

public interface EmployeesProvider {

    /**
     * @return all employees in the company flattened in a list.
     * <p> If employee1 is a subordinate of employee2, then both employee1 and employee2 will be returned in the list.
     * </p>
     * <p>
     * The organization hierarchy is modeled via tree:
     * <ul>
     * <li>
     * Cyclic dependencies for subordinates are not allowed. For example, if employee2 is subordinate of employee1, it
     * is not allowed for employee1 to be subordinate of employee2.
     * </li>
     * <li>
     * Each employee can be present only once as a subordinate. For example it is not allowed for employee3 to be 
     * subordinate of both employee1 and employee2.
     * </li>
     * </ul>
     * </p>
     */
    List<Employee> getEmployees();
}
