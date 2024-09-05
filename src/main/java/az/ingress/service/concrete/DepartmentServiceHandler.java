package az.ingress.service.concrete;

import az.ingress.dao.entity.DepartmentEntity;
import az.ingress.dao.repository.DepartmentRepository;
import az.ingress.service.abstraction.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceHandler implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public void saveDepartment(DepartmentEntity department) {
        departmentRepository.save(department);
    }
}
