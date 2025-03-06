package com.prashant.RestApiProject.controller;

import com.prashant.RestApiProject.entity.Employee;
import com.prashant.RestApiProject.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> retrieveAllEmployees(){
        return employeeService.getAll();
    }
    @GetMapping("/employee/{id}")
    public Employee retrieveEmployee(@PathVariable int id){
        return employeeService.get(id);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
        Employee savedEmployee=employeeService.save(employee);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEmployee.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/employee-remove/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.delete(id);
    }

    @PutMapping("/employee-update/{id}")
    public String updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        return employeeService.update(employee,id);
    }

}
