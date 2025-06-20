package org.reactivestax.io.utility;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.reactivestax.io.dto.EmployeeDTO;
import org.reactivestax.io.model.Employee;

@Mapper(componentModel = "spring", uses = DepartmentHelper.class)
public interface EmployeeHelper {
    @Mapping(source = "department", target = "department")
    EmployeeDTO toDto(Employee employee);
    @Mapping(source = "department", target = "department")
    Employee toEntity(EmployeeDTO employeeDTO);
}
