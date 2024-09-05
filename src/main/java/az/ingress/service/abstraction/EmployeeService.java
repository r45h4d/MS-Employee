package az.ingress.service.abstraction;

import az.ingress.dao.entity.EmployeeEntity;
import az.ingress.model.response.EmployeeResponse;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    void saveEmployee(EmployeeEntity employee);

    EmployeeResponse getEmployee(Long id);
}
