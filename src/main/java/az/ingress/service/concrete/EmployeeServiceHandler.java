package az.ingress.service.concrete;

import az.ingress.aspect.Log;
import az.ingress.aspect.LogIgnore;
import az.ingress.dao.entity.EmployeeEntity;
import az.ingress.dao.repository.DepartmentRepository;
import az.ingress.dao.repository.EmployeeRepository;
import az.ingress.exception.NotFoundException;
import az.ingress.model.CacheData;
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
    private final CacheService cacheService;
    @Log
    @Transactional
    @Override
    public void saveEmployee(EmployeeEntity employee) {
        departmentRepository.save(employee.getDepartment());
        employeeRepository.save(employee);
        cacheService.save(employee.getId(), employee.getName());
    }

    @LogIgnore
    public String getEmployeeName(Long id) {
        CacheData data = cacheService.get("ms-employee:employeeId:"+id);
        if(data==null) {
            data = new CacheData(getEmployee(id).getName());
            cacheService.save(id, data.getName());
        }
        return data.getName();
    }

    @LogIgnore
    @Override
    public EmployeeResponse getEmployee(Long id) {
        return buildEmployeeResponse(employeeRepository.findById(id).orElseThrow(()->new NotFoundException(EMPLOYEE_NOT_FOUND.getMessage(), EMPLOYEE_NOT_FOUND.getCode())));
    }
}
