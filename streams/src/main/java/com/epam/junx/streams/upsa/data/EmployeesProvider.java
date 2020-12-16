package com.epam.junx.streams.upsa.data;

import com.epam.junx.streams.upsa.domain.Employee;
import java.util.List;

public interface EmployeesProvider {

    List<Employee> getEmployees();
}
