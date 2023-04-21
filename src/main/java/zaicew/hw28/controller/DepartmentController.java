package zaicew.hw28.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zaicew.hw28.Employee;
import zaicew.hw28.service.NewService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final NewService service;

    public DepartmentController(NewService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Optional<Employee> maxSalaryFromDepartment(@RequestParam("departmentId") int department) {
        return service.maxSalaryDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryFromDepartment(@RequestParam("departmentId") int department) {
        return service.minSalaryDepartment(department);
    }
    @GetMapping(value = "/all",params = "departmentId")
    public List<Employee> allManDepartment(@RequestParam("departmentId") int department){
        return service.getAllManDepartment(department);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> collectByDepartment(){
        return service.getCollectByDepartment();
    }

}
