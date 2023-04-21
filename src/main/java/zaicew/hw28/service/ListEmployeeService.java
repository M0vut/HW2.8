package zaicew.hw28.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import zaicew.hw28.Employee;
import zaicew.hw28.exception.EmployeeAlreadyAddedException;
import zaicew.hw28.exception.EmployeeNotFoundException;
import zaicew.hw28.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
@Primary
public class ListEmployeeService implements EmployeeService {
    private static final int CAPACITY = 10;
    List<Employee> staff = new ArrayList<>();


    @Override
    public Employee addEmployee(String firstName, String lastName,int department,int salary) {
        Employee temp = new Employee(firstName, lastName,department,salary);
        if (staff.size() >= CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }
        if (staff.contains(temp)) {
            throw new EmployeeAlreadyAddedException();
        }
        staff.add(temp);
        return temp;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName,int department,int salary) {
        int index = staff.indexOf(new Employee(firstName, lastName,department,salary));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }


        return staff.remove(index);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int department,int salary) {
        int index = staff.indexOf(new Employee(firstName, lastName, department, salary));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return staff.get(index);
    }
    @Override
    public List<Employee> findAll() {
        return Collections.unmodifiableList(staff);
    }


}
