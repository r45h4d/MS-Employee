package az.ingress.service.abstraction;

import az.ingress.dao.entity.DepartmentEntity;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    void saveDepartment(DepartmentEntity project);
}
