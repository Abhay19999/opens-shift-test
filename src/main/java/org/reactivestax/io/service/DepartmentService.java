package org.reactivestax.io.service;

import org.reactivestax.io.dto.DepartmentDTO;
import org.reactivestax.io.model.Department;
import org.reactivestax.io.repo.DepartmentRepository;
import org.reactivestax.io.utility.DepartmentHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentHelper departmentHelper;


    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO){
        Department department = departmentHelper.toEntity(departmentDTO);
        departmentRepository.save(department);
        return departmentHelper.toDto(department);
    }
    public List<DepartmentDTO> getAllDepartment(){
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO>departmentDTOS = new ArrayList<>();
        departments.forEach(d->{
            DepartmentDTO dto = departmentHelper.toDto(d);
            departmentDTOS.add(dto);
        });
        return departmentDTOS;
    }
}
