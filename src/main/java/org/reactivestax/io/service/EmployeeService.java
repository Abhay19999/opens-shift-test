package org.reactivestax.io.service;


import org.reactivestax.io.dto.EmployeeDTO;
import org.reactivestax.io.model.Address;
import org.reactivestax.io.model.Department;
import org.reactivestax.io.model.Employee;
import org.reactivestax.io.repo.EmployeeRepository;
import org.reactivestax.io.utility.EmployeeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeHelper employeeHelper;

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeHelper.toEntity(employeeDTO);
        employeeRepository.save(employee);

        return employeeHelper.toDto(employee);
    }

//    private EmployeeDTO covertToDTO(Employee employee) {
//        return EmployeeDTO.builder()
//                .id(employee.getId())
//                .name(employee.getName())
//                .address(employee.getAddress().getCity())
//                .department(employee.getDepartment().getDepartmentName())
//                .build();
//    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employeeList.forEach(employee -> {
            EmployeeDTO employeeDTO = employeeHelper.toDto(employee);
            employeeDTOS.add(employeeDTO);
        });

        return employeeDTOS;
    }

    public String deleteEmployee(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isPresent()){
            employeeRepository.deleteById(employeeId);
            return "Employee has been deleted";
        }

        return "Employee does not exists";
    }

    public EmployeeDTO editEmployee(Long employeeId,EmployeeDTO employeeDTO) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isPresent()){


        }
return null;
    }
}
