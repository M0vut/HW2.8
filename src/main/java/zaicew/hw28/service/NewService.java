package zaicew.hw28.service;
import org.springframework.stereotype.Service;
import zaicew.hw28.Employee;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class NewService {

    private final EmployeeService employeeService;

    public NewService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Optional <Employee> maxSalaryDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(employee -> employee.getSalary()));

    }


    public Employee minSalaryDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .get();
    }


    public List<Employee> getAllManDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }


    public Map<Integer, List<Employee>> getCollectByDepartment() {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
    }

}


