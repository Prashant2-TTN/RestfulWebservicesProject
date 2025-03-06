package com.prashant.RestApiProject.service;

import com.prashant.RestApiProject.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class EmployeeService {

    static int userCount=0;
    private static List<Employee> employeeList=new ArrayList<>();

    static{
        employeeList.add(new Employee("prashant",23,++userCount));
        employeeList.add(new Employee("mukul",23,++userCount));
        employeeList.add(new Employee("mayanktiwari",23,++userCount));
    }

    public List<Employee> getAll(){
        return employeeList;
    }

    public Employee get(int id){
        Predicate<? super Employee> predicate =(employee)->employee.getId()==id;
        return employeeList.stream().filter(predicate).findFirst().get();
    }

    public Employee save( @Validated Employee employee){
        employee.setId(++userCount);
        employeeList.add(employee);
        return employee;
    }
    public String delete(int id){
        Predicate<Employee> predicate=emp->emp.getId()==(id);
        employeeList.removeIf(predicate);
        return " Employee id :"+id+" deleted Successfully";
    }

    public String update(Employee employee,int id){
     Optional<Employee> optEmployee=employeeList.stream().filter(emp->emp.getId()==id).findFirst();
     if(optEmployee.isPresent()){
         Employee existing=optEmployee.get();
         existing.setName(employee.getName());
         existing.setAge(employee.getAge());
        return "Employee id : "+id+" updated successfully";
     }
        return "Employee id : "+id+" not found";
    }
}
