package org.reactivestax.io.utility;

import org.mapstruct.Mapper;
import org.reactivestax.io.dto.DepartmentDTO;
import org.reactivestax.io.model.Department;
import org.reactivestax.io.repo.DepartmentRepository;

@Mapper(componentModel = "spring")
public interface DepartmentHelper {
    DepartmentDTO toDto(Department department);

    Department toEntity(DepartmentDTO departmentDTO);
}
