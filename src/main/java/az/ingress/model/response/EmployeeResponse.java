package az.ingress.model.response;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    Long id;
    String name;
    BigDecimal salary;
    DepartmentResponse department;
}
