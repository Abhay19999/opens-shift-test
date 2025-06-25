package org.reactivestax.io.controller;


import org.reactivestax.io.dto.EmployeeDTO;
import org.reactivestax.io.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employee")
    public ResponseEntity<String> testKubernetes(){
        return ResponseEntity.ok("Working fine");
    }
    @GetMapping("/webhook")
    public ResponseEntity<String> testJenkins(){
        return ResponseEntity.ok("GitHub Test working");
    }
    public List<EmployeeDTO> getEmployees(){
        return employeeService.getAllEmployees();
    }
    @PostMapping("/employee")
    public EmployeeDTO addEmployeeWithAddress(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.addEmployee(employeeDTO);
    }
    @DeleteMapping("/employee")
    public ResponseEntity<String> deleteEmployee(@RequestHeader("x-employee-id") Long employeeId){
       return ResponseEntity.ok(employeeService.deleteEmployee(employeeId));
    }
    @PatchMapping("/employee")
    public EmployeeDTO editEmployee(@RequestHeader("x-employee-id") Long employeeId, @RequestBody EmployeeDTO employeeDTO){
       return  employeeService.editEmployee(employeeId,employeeDTO);
    }
}
