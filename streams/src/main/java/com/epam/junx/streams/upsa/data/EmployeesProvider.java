package com.epam.junx.streams.upsa.data;

import com.epam.junx.streams.upsa.domain.Employee;
import java.util.List;

public interface EmployeesProvider {

    /**
     * @return all employees in the company flattened in a list. <br/> If employee1 is a subordinate of employee2,
     * then both employee1 and employee2 will be returned in the list and
     */
    List<Employee> getEmployees();
}
