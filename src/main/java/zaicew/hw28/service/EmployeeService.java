package zaicew.hw28.service;

import org.springframework.stereotype.Service;
import zaicew.hw28.Employee;

import java.util.Collection;

@Service
public interface EmployeeService  {
    Employee addEmployee(String firstName, String lastName, int department, int salary);
    Employee removeEmployee(String firstName, String lastName, int department, int salary);
    Employee findEmployee(String firstName, String lastName, int department, int salary);
    Collection<Employee> findAll();
}
