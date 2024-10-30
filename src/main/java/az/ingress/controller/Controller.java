package az.ingress.controller;

import az.ingress.dao.entity.EmployeeEntity;
import az.ingress.model.response.EmployeeResponse;
import az.ingress.service.concrete.EmployeeServiceHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class Controller {
    private final EmployeeServiceHandler employeeServiceHandler;

    @PostMapping("/employee")
    @ResponseStatus(CREATED)
    public void addEmployee(@RequestBody EmployeeEntity employee) {
        employeeServiceHandler.saveEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    @ResponseStatus(OK)
    public EmployeeResponse getEmployee(@PathVariable Long id){
        return employeeServiceHandler.getEmployee(id);
    }

    @GetMapping("/employees/{id}/name")
    @ResponseStatus(OK)
    public String getEmployeeName(@PathVariable Long id) {
        return employeeServiceHandler.getEmployeeName(id);
    }
}
