package az.ingress.controller;

import az.ingress.model.response.EmployeeResponse;
import az.ingress.service.concrete.EmployeeServiceHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("internal/v1")
@RequiredArgsConstructor
public class InternalController {
    private final EmployeeServiceHandler employeeServiceHandler;

    @GetMapping("/employees/{id}")
    @ResponseStatus(OK)
    public EmployeeResponse getEmployee(@PathVariable Long id){
        return employeeServiceHandler.getEmployee(id);
    }
}
