package az.ingress.service.concrete;

import az.ingress.aspect.Log;
import az.ingress.aspect.LogIgnore;
import az.ingress.dao.entity.EmployeeEntity;
import az.ingress.dao.repository.DepartmentRepository;
import az.ingress.dao.repository.EmployeeRepository;
import az.ingress.exception.NotFoundException;
import az.ingress.model.response.EmployeeResponse;
import az.ingress.service.abstraction.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static az.ingress.exception.ExceptionConstants.EMPLOYEE_NOT_FOUND;
import static az.ingress.model.mapper.EMPLOYEE_MAPPER.*;

@Service
@RequiredArgsConstructor
public class EmployeeServiceHandler implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Log
    @Transactional
    @Override
    public void saveEmployee(EmployeeEntity employee) {
        departmentRepository.save(employee.getDepartment());
        employeeRepository.save(employee);
    }

    @LogIgnore
    @Override
    public EmployeeResponse getEmployee(Long id) {
        return buildEmployeeResponse(employeeRepository.findById(id).orElseThrow(()->new NotFoundException(EMPLOYEE_NOT_FOUND.getMessage(), EMPLOYEE_NOT_FOUND.getCode())));
    }
}
