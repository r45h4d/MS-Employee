package az.ingress.model.mapper;

import az.ingress.dao.entity.EmployeeEntity;
import az.ingress.model.response.EmployeeResponse;
import org.springframework.stereotype.Component;

@Component
public class EMPLOYEE_MAPPER {
    public static EmployeeResponse buildEmployeeResponse(EmployeeEntity employee){
        return EmployeeResponse.builder().
                id(employee.getId()).
                name(employee.getName()).
                salary(employee.getSalary()).
                department(DEPARTMENT_MAPPER.buildDepartmentResponse(employee.getDepartment())).
                build();
    }
}
