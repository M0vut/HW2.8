package zaicew.hw28.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zaicew.hw28.Employee;
import zaicew.hw28.service.EmployeeService;

import java.util.Collections;
import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

 
    @GetMapping
    public String hello(){
        return "HELLO";
    }
    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam int department,
                        @RequestParam int salary){
        return service.addEmployee(firstName,lastName,department,salary);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("department") int department,
                           @RequestParam("salary") int salary){
        return service.removeEmployee(firstName,lastName,department,salary);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam int department,
                         @RequestParam int salary){
        return service.findEmployee(firstName,lastName, department, salary);
    }
    @GetMapping("/all")
    public List<Employee> allPrint(){
        return (List<Employee>) service.findAll();
    }

}


