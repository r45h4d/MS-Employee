package az.ingress.model.mapper;

import az.ingress.dao.entity.DepartmentEntity;
import az.ingress.model.response.DepartmentResponse;
import org.springframework.stereotype.Component;

@Component
public class DEPARTMENT_MAPPER {
    public static DepartmentResponse buildDepartmentResponse(DepartmentEntity department){
        return DepartmentResponse.builder().
                id(department.getId()).
                name(department.getName()).
                build();
    }
}
