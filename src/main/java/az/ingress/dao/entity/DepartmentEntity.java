package az.ingress.dao.entity;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String name;

    @OneToMany(mappedBy = "department", cascade = {PERSIST, MERGE})
    private List<EmployeeEntity> employees;
}
