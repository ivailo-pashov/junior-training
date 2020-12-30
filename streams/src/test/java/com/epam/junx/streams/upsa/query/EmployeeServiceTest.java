package com.epam.junx.streams.upsa.query;

import static com.epam.junx.streams.upsa.domain.Role.DEVELOPER;
import static com.epam.junx.streams.upsa.domain.Role.MANAGER;
import static com.epam.junx.streams.upsa.domain.Role.TEST_ENGINEER;
import static com.epam.junx.streams.upsa.domain.Title.JUNIOR;
import static com.epam.junx.streams.upsa.domain.Title.LEAD;
import static com.epam.junx.streams.upsa.domain.Title.REGULAR;
import static com.epam.junx.streams.upsa.domain.Title.SENIOR;

import com.epam.junx.streams.upsa.domain.Employee;
import com.epam.junx.streams.upsa.domain.Role;
import com.epam.junx.streams.upsa.domain.Skill;
import com.epam.junx.streams.upsa.domain.Title;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmployeeServiceTest {

    @Test
    void task_1_FindAllEmployeesWithExperienceGreaterThan_Base() {
        doTestWithoutOrder(
            ImmutableList.of(
                employee("John", "Doe", 3),
                employee("Marry", "Jane", 2),
                employee("Harry", "Kane", 1)
            ),
            service -> service.findAllEmployeesWithExperienceGreaterThan(2),
            ImmutableList.of(
                employee("John", "Doe", 3)
            )
        );
    }

    @Test
    void task_1_findAllEmployeesWithExperienceGreaterThan_Empty() {
        doTestWithoutOrder(
            ImmutableList.of(),
            service -> service.findAllEmployeesWithExperienceGreaterThan(2),
            ImmutableList.of()
        );
    }

    @Test
    void task_2_FindAllEmployeesUniqueLastNames_Base() {
        doTest(
            ImmutableList.of(
                employee("Emily", "Parker", 5),
                employee("John", "Doe", 3),
                employee("Marry", "Jane", 2),
                employee("Albert", "Doe", 1)
            ),
            EmployeeService::findAllEmployeesUniqueLastNames,
            ImmutableList.of("Doe", "Jane", "Parker")
        );
    }

    @Test
    void task_2_findAllEmployeesUniqueLastNames_Empty() {
        doTest(
            ImmutableList.of(),
            EmployeeService::findAllEmployeesUniqueLastNames,
            ImmutableList.of()
        );
    }

    @Test
    void task_3_FindAllJuniorEmployeesUniqueFirstNames_Base() {
        doTestWithoutOrder(
            ImmutableList.of(
                employee("Emily", "Parker", REGULAR, DEVELOPER, 4),
                employee("John", "Doe", JUNIOR, DEVELOPER, 1),
                employee("Albert", "Einstein", JUNIOR, MANAGER, 10),
                employee("Marry", "Jane", LEAD, TEST_ENGINEER, 2),
                employee("Albert", "Doe", JUNIOR, TEST_ENGINEER, 1)
            ),
            EmployeeService::findAllJuniorEmployeesUniqueFirstNames,
            ImmutableList.of("John", "Albert")
        );
    }

    @Test
    void task_3_FindAllJuniorEmployeesUniqueFirstNames_Empty() {
        doTestWithoutOrder(
            ImmutableList.of(),
            EmployeeService::findAllJuniorEmployeesUniqueFirstNames,
            ImmutableList.of()
        );
    }

    @Test
    void task_4_FindTopExperiencedEmployees_Base() {
        doTest(
            ImmutableList.of(
                employee("Emily", "Parker", REGULAR, DEVELOPER, 4),
                employee("John", "Doe", REGULAR, DEVELOPER, 3),
                employee("Marry", "Jane", LEAD, TEST_ENGINEER, 2),
                employee("Albert", "Doe", JUNIOR, TEST_ENGINEER, 1)
            ),
            employeeService -> employeeService.findTopExperiencedEmployees(4),
            ImmutableList.of("Marry Jane", "Emily Parker", "John Doe", "Albert Doe")
        );
    }

    @Test
    void task_4_FindTopExperiencedEmployees_Empty() {
        doTest(
            ImmutableList.of(),
            employeeService -> employeeService.findTopExperiencedEmployees(10),
            ImmutableList.of()
        );
    }

    @Test
    void task_4_FindTopExperiencedEmployees_CutList() {
        doTest(
            ImmutableList.of(
                employee("Emily", "Parker", REGULAR, DEVELOPER, 4),
                employee("John", "Doe", REGULAR, DEVELOPER, 3),
                employee("Marry", "Jane", LEAD, TEST_ENGINEER, 2),
                employee("Albert", "Doe", JUNIOR, TEST_ENGINEER, 1)
            ),
            employeeService -> employeeService.findTopExperiencedEmployees(1),
            ImmutableList.of("Marry Jane")
        );
    }

    @Test
    void task_4_FindTopExperiencedEmployees_RestrictTo0() {
        doTest(
            ImmutableList.of(
                employee("Emily", "Parker", REGULAR, DEVELOPER, 4),
                employee("John", "Doe", REGULAR, DEVELOPER, 3),
                employee("Marry", "Jane", LEAD, TEST_ENGINEER, 2),
                employee("Albert", "Doe", JUNIOR, TEST_ENGINEER, 1)
            ),
            employeeService -> employeeService.findTopExperiencedEmployees(0),
            ImmutableList.of()
        );
    }

    @Test
    void task_5_FindAllSubordinates_Base() {
        ImmutableList<Employee> employees = ImmutableList.of(
            employee("Emily", "Parker", REGULAR, DEVELOPER, 4, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("David", "Campbell", REGULAR, DEVELOPER, 4),
                    employee("Theresa", "Hudson", REGULAR, DEVELOPER, 3)
                )),
            employee("John", "Doe", REGULAR, DEVELOPER, 3, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("Lauren", "Hunter", REGULAR, DEVELOPER, 4)
                )),
            employee("Marry", "Jane", LEAD, TEST_ENGINEER, 2, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("Owen", "James", REGULAR, DEVELOPER, 4),
                    employee("Vanessa", "Powell", REGULAR, DEVELOPER, 4),
                    employee("Madeleine", "Ellison", REGULAR, DEVELOPER, 3)
                )),
            employee("Albert", "Doe", JUNIOR, TEST_ENGINEER, 1, ImmutableSet.of(),
                ImmutableSet.of(

                )),
            employee("David", "Campbell", REGULAR, DEVELOPER, 4),
            employee("Theresa", "Hudson", REGULAR, DEVELOPER, 3),
            employee("Lauren", "Hunter", REGULAR, DEVELOPER, 4),
            employee("Owen", "James", REGULAR, DEVELOPER, 4),
            employee("Vanessa", "Powell", REGULAR, DEVELOPER, 4),
            employee("Madeleine", "Ellison", REGULAR, DEVELOPER, 3)

        );
        doTestWithoutOrder(
            employees,
            employeeService -> employeeService.findAllSubordinates(employees),
            ImmutableList.of(
                "David Campbell",
                "Theresa Hudson",
                "Lauren Hunter",
                "Owen James",
                "Vanessa Powell",
                "Madeleine Ellison"
            )
        );
    }

    @Test
    void task_5_FindAllSubordinates_Duplicates() {
        ImmutableList<Employee> employees = ImmutableList.of(
            employee("Emily", "Parker", REGULAR, DEVELOPER, 4, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("David", "Campbell", REGULAR, DEVELOPER, 4),
                    employee("Theresa", "Hudson", REGULAR, DEVELOPER, 3)
                )),
            employee("John", "Doe", REGULAR, DEVELOPER, 3, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("Lauren", "Hunter", REGULAR, DEVELOPER, 4)
                )),
            employee("Marry", "Jane", LEAD, TEST_ENGINEER, 2, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("Owen", "James", REGULAR, DEVELOPER, 4),
                    employee("Vanessa", "Powell", REGULAR, DEVELOPER, 4),
                    employee("Madeleine", "Ellison", REGULAR, DEVELOPER, 3)
                )),
            employee("Albert", "Doe", JUNIOR, TEST_ENGINEER, 1, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("Owen", "James", SENIOR, TEST_ENGINEER, 4)
                )),
            employee("David", "Campbell", REGULAR, DEVELOPER, 4),
            employee("Theresa", "Hudson", REGULAR, DEVELOPER, 3),
            employee("Lauren", "Hunter", REGULAR, DEVELOPER, 4),
            employee("Owen", "James", REGULAR, DEVELOPER, 4),
            employee("Vanessa", "Powell", REGULAR, DEVELOPER, 4),
            employee("Madeleine", "Ellison", REGULAR, DEVELOPER, 3),
            employee("Owen", "James", SENIOR, TEST_ENGINEER, 4)
        );
        doTestWithoutOrder(
            employees,
            employeeService -> employeeService.findAllSubordinates(employees),
            ImmutableList.of(
                "David Campbell",
                "Theresa Hudson",
                "Lauren Hunter",
                "Owen James",
                "Vanessa Powell",
                "Madeleine Ellison",
                "Owen James"
            )
        );
    }

    @Test
    void task_5_FindAllSubordinates_Empty() {
        doTestWithoutOrder(
            ImmutableList.of(),
            employeeService -> employeeService.findAllSubordinates(ImmutableList.of()),
            ImmutableList.of()
        );
    }

    @Test
    void task_10_FindTotalSkillsYearsPerTeam_Base() {
        //TODO implementation
    }

    @Test
    void task_10_FindTotalSkillsYearsPerTeam_IncludingManager() {
        //TODO implementation
    }

    @Test
    void task_10_FindTotalSkillsYearsPerTeam_Empty() {
        doTest(
            ImmutableList.of(),
            EmployeeService::findTotalSkillsYearsPerTeam,
            ImmutableMap.of()
        );
    }

    @Test
    void task_12_FindManagerWithMostDirectSubordinates_Base() {
        doTest(
            ImmutableList.of(
                employee("Emily", "Parker", REGULAR, DEVELOPER, 4, ImmutableSet.of(),
                    ImmutableSet.of(
                        employee("David", "Campbell", REGULAR, DEVELOPER, 4),
                        employee("Theresa", "Hudson", REGULAR, DEVELOPER, 3)
                    )),
                employee("John", "Doe", REGULAR, DEVELOPER, 3, ImmutableSet.of(),
                    ImmutableSet.of(
                        employee("Lauren", "Hunter", REGULAR, DEVELOPER, 4)
                    )),
                employee("Marry", "Jane", LEAD, TEST_ENGINEER, 2, ImmutableSet.of(),
                    ImmutableSet.of(
                        employee("Owen", "James", REGULAR, DEVELOPER, 4),
                        employee("Vanessa", "Powell", REGULAR, DEVELOPER, 4),
                        employee("Madeleine", "Ellison", REGULAR, DEVELOPER, 3)
                    )),
                employee("Albert", "Doe", JUNIOR, TEST_ENGINEER, 1, ImmutableSet.of(),
                    ImmutableSet.of(
                        employee("Owen", "James", SENIOR, TEST_ENGINEER, 4)
                    )),
                employee("David", "Campbell", REGULAR, DEVELOPER, 4),
                employee("Theresa", "Hudson", REGULAR, DEVELOPER, 3),
                employee("Lauren", "Hunter", REGULAR, DEVELOPER, 4),
                employee("Owen", "James", REGULAR, DEVELOPER, 4),
                employee("Vanessa", "Powell", REGULAR, DEVELOPER, 4),
                employee("Madeleine", "Ellison", REGULAR, DEVELOPER, 3),
                employee("Owen", "James", SENIOR, TEST_ENGINEER, 4)
            ),
            EmployeeService::findManagerWithMostDirectSubordinates,
            "Marry Jane"
        );
    }

    @Test
    void task_12_FindManagerWithMostDirectSubordinates_Multiple() {
        List<Employee> employees = ImmutableList.of(
            employee("Emily", "Parker", REGULAR, DEVELOPER, 4, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("David", "Campbell", REGULAR, DEVELOPER, 4),
                    employee("Theresa", "Hudson", REGULAR, DEVELOPER, 3)
                )),
            employee("John", "Doe", REGULAR, DEVELOPER, 3, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("Lauren", "Hunter", REGULAR, DEVELOPER, 4)
                )),
            employee("Marry", "Jane", LEAD, TEST_ENGINEER, 2, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("Owen", "James", REGULAR, DEVELOPER, 4),
                    employee("Vanessa", "Powell", REGULAR, DEVELOPER, 4)
                )),
            employee("Albert", "Doe", JUNIOR, TEST_ENGINEER, 1, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("Owen", "James", SENIOR, TEST_ENGINEER, 4)
                )),
            employee("David", "Campbell", REGULAR, DEVELOPER, 4),
            employee("Theresa", "Hudson", REGULAR, DEVELOPER, 3),
            employee("Lauren", "Hunter", REGULAR, DEVELOPER, 4),
            employee("Owen", "James", REGULAR, DEVELOPER, 4),
            employee("Vanessa", "Powell", REGULAR, DEVELOPER, 4),
            employee("Madeleine", "Ellison", REGULAR, DEVELOPER, 3),
            employee("Owen", "James", SENIOR, TEST_ENGINEER, 4)
        );

        String actual = getEmployeeService(employees).findManagerWithMostDirectSubordinates();

        ImmutableSet<String> expected = ImmutableSet.of("Emily Parker", "Marry Jane");
        Assertions.assertTrue(expected.contains(actual), actual + " not in " + expected);
    }

    @Test
    void task_12_FindManagerWithMostDirectSubordinates_Empty() {
        doTest(
            ImmutableList.of(),
            EmployeeService::findManagerWithMostDirectSubordinates,
            null
        );
    }

    @Test
    void task_13_FindManagerWithMostTransitiveSubordinates_Base() {
        Employee employee1Level3 = employee("Peter", "Gray", REGULAR, DEVELOPER, 3);
        Employee employee2Level3 = employee("Simon", "Allan", REGULAR, DEVELOPER, 3);
        Employee employee3Level3 = employee("Molly", "Jones", REGULAR, DEVELOPER, 3);
        Employee employeeLevel2 = employee("Julia", "Hart", REGULAR, DEVELOPER, 4, ImmutableSet.of(),
            ImmutableSet.of(employee1Level3, employee2Level3, employee3Level3));
        Employee employeeLevel1 = employee("Lauren", "Hunter", LEAD, DEVELOPER, 4, ImmutableSet.of(),
            ImmutableSet.of(employeeLevel2));
        ImmutableList<Employee> employees = ImmutableList.of(
            employee("Emily", "Parker", REGULAR, DEVELOPER, 4, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("David", "Campbell", REGULAR, DEVELOPER, 4),
                    employee("Theresa", "Hudson", REGULAR, DEVELOPER, 3)
                )),
            employee("John", "Doe", LEAD, DEVELOPER, 3, ImmutableSet.of(),
                ImmutableSet.of(
                    employeeLevel1
                )),
            employee("Marry", "Jane", LEAD, TEST_ENGINEER, 2, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("Owen", "James", REGULAR, DEVELOPER, 4),
                    employee("Vanessa", "Powell", REGULAR, DEVELOPER, 4),
                    employee("Madeleine", "Ellison", REGULAR, DEVELOPER, 3)
                )),
            employee("Albert", "Doe", JUNIOR, TEST_ENGINEER, 1, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("Owen", "James", SENIOR, TEST_ENGINEER, 4)
                )),
            employee("David", "Campbell", REGULAR, DEVELOPER, 4),
            employee("Theresa", "Hudson", REGULAR, DEVELOPER, 3),
            employeeLevel1,
            employeeLevel2,
            employee1Level3,
            employee2Level3,
            employee3Level3,
            employee("Owen", "James", REGULAR, DEVELOPER, 4),
            employee("Vanessa", "Powell", REGULAR, DEVELOPER, 4),
            employee("Madeleine", "Ellison", REGULAR, DEVELOPER, 3),
            employee("Owen", "James", SENIOR, TEST_ENGINEER, 4)
        );
        doTest(
            employees,
            EmployeeService::findManagerWithMostTransitiveSubordinates,
            "John Doe"
        );
    }

    @Test
    void task_13_FindManagerWithMostTransitiveSubordinates_Multiple() {
        Employee employeeLevel3 = employee("Peter", "Gray", REGULAR, DEVELOPER, 3);
        Employee employeeLevel2 = employee("Julia", "Hart", REGULAR, DEVELOPER, 4, ImmutableSet.of(),
            ImmutableSet.of(employeeLevel3));
        Employee employeeLevel1 = employee("Lauren", "Hunter", LEAD, DEVELOPER, 4, ImmutableSet.of(),
            ImmutableSet.of(employeeLevel2));
        ImmutableList<Employee> employees = ImmutableList.of(
            employee("Emily", "Parker", REGULAR, DEVELOPER, 4, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("David", "Campbell", REGULAR, DEVELOPER, 4),
                    employee("Theresa", "Hudson", REGULAR, DEVELOPER, 3)
                )),
            employee("John", "Doe", LEAD, DEVELOPER, 3, ImmutableSet.of(),
                ImmutableSet.of(
                    employeeLevel1
                )),
            employee("Marry", "Jane", LEAD, TEST_ENGINEER, 2, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("Owen", "James", REGULAR, DEVELOPER, 4),
                    employee("Vanessa", "Powell", REGULAR, DEVELOPER, 4),
                    employee("Madeleine", "Ellison", REGULAR, DEVELOPER, 3)
                )),
            employee("Albert", "Doe", JUNIOR, TEST_ENGINEER, 1, ImmutableSet.of(),
                ImmutableSet.of(
                    employee("Owen", "James", SENIOR, TEST_ENGINEER, 4)
                )),
            employee("David", "Campbell", REGULAR, DEVELOPER, 4),
            employee("Theresa", "Hudson", REGULAR, DEVELOPER, 3),
            employeeLevel1,
            employeeLevel2,
            employeeLevel3,
            employee("Owen", "James", REGULAR, DEVELOPER, 4),
            employee("Vanessa", "Powell", REGULAR, DEVELOPER, 4),
            employee("Madeleine", "Ellison", REGULAR, DEVELOPER, 3),
            employee("Owen", "James", SENIOR, TEST_ENGINEER, 4)
        );

        String actual = getEmployeeService(employees).findManagerWithMostTransitiveSubordinates();

        ImmutableSet<String> expected = ImmutableSet.of("John Doe", "Marry Jane");
        Assertions.assertTrue(expected.contains(actual), actual + " not in " + expected);
    }

    @Test
    void task_13_FindManagerWithMostTransitiveSubordinates_Empty() {
        doTest(
            ImmutableList.of(),
            EmployeeService::findManagerWithMostTransitiveSubordinates,
            null
        );
    }

    @Test
    void task_14_VerifyNoLeadManagerExists_Base() {
        doTest(
            ImmutableList.of(
                employee("Emily", "Parker", REGULAR, DEVELOPER, 4),
                employee("John", "Doe", REGULAR, DEVELOPER, 3),
                employee("Marry", "Jane", LEAD, TEST_ENGINEER, 2),
                employee("Owen", "James", REGULAR, DEVELOPER, 4),
                employee("Albert", "Doe", JUNIOR, TEST_ENGINEER, 1)
            ),
            EmployeeService::verifyNoLeadManagerExists,
            true
        );
    }

    @Test
    void task_14_VerifyNoLeadManagerExists_Negative() {
        doTest(
            ImmutableList.of(
                employee("Emily", "Parker", REGULAR, DEVELOPER, 4),
                employee("John", "Doe", LEAD, MANAGER, 3),
                employee("Marry", "Jane", LEAD, TEST_ENGINEER, 2),
                employee("Owen", "James", REGULAR, DEVELOPER, 4),
                employee("Albert", "Doe", JUNIOR, TEST_ENGINEER, 1)
            ),
            EmployeeService::verifyNoLeadManagerExists,
            false
        );
    }

    @Test
    void task_14_VerifyNoLeadManagerExists_Empty() {
        doTest(
            ImmutableList.of(),
            EmployeeService::verifyNoLeadManagerExists,
            true
        );
    }

    @Test
    void task_15_GetRatioBetweenDevelopersAndTestEngineers_Base() {
        doTest(
            ImmutableList.of(
                employee("Emily", "Parker", REGULAR, DEVELOPER, 4),
                employee("John", "Doe", REGULAR, DEVELOPER, 3),
                employee("Marry", "Jane", LEAD, TEST_ENGINEER, 2),
                employee("Owen", "James", REGULAR, DEVELOPER, 4),
                employee("Albert", "Doe", JUNIOR, TEST_ENGINEER, 1)
            ),
            EmployeeService::getRatioBetweenDevelopersAndTestEngineers,
            1.5d
        );
    }
    
    //TODO add test for findMostSkilledUnit

    private static <T> void doTestWithoutOrder(List<Employee> employees, Function<EmployeeService, List<T>> invocation,
        List<T> expected) {
        doTest(employees, invocation, expected, list -> list.stream()
            .sorted(Comparator.comparing(Objects::hashCode))
            .collect(Collectors.toList())
        );
    }

    private static <T> void doTest(List<Employee> employees, Function<EmployeeService, T> invocation, T expected) {
        doTest(employees, invocation, expected, UnaryOperator.identity());
    }

    private static <T> void doTest(List<Employee> employees, Function<EmployeeService, T> invocation, T expected,
        UnaryOperator<T> resultTransformer) {
        EmployeeService employeeService = getEmployeeService(employees);
        T actual = invocation.apply(employeeService);
        Assertions.assertEquals(resultTransformer.apply(expected), resultTransformer.apply(actual));
    }

    private static Employee employee(String firstName, String lastName, int yearsOfExperience) {
        return employee(firstName, lastName, null, null, yearsOfExperience);
    }

    private static Employee employee(String firstName, String lastName, Title title, Role role,
        int yearsOfExperience) {
        return employee(firstName, lastName, title, role, yearsOfExperience, ImmutableSet.of());
    }

    private static Employee employee(String firstName, String lastName, Title title, Role role,
        int yearsOfExperience, Set<Skill> skills) {
        return employee(firstName, lastName, title, role, yearsOfExperience, skills, ImmutableSet.of());
    }

    private static Employee employee(String firstName, String lastName, Title title, Role role,
        int yearsOfExperience, Set<Skill> skills, Set<Employee> subordinates) {
        long id = Objects.hash(firstName, lastName);
        Employee employee = new Employee(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setRole(role);
        employee.setTitle(title);
        employee.setSkills(skills);
        employee.setSubordinates(subordinates);
        employee.setYearsOfExperience(yearsOfExperience);
        return employee;
    }

    private static EmployeeService getEmployeeService(List<Employee> employees) {
        return new EmployeeService(() -> employees);
    }
}
