package com.jtarango.hr.controller;

import com.jtarango.hr.exception.ResourceNotFoundException;
import com.jtarango.hr.model.Employee;
import com.jtarango.hr.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hr-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        List<Employee> employees = employeeService.listEmployees();
        employees.forEach(employee -> logger.info(employee.toString()));
        return employees;
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee){
        logger.info("Employee to add: " + employee);
        employeeService.setEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null){
            throw new ResourceNotFoundException("Id Not Found: " + id);
        }
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> setEmployee(@PathVariable Integer id, @RequestBody Employee receivedEmployee){
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null)
            throw  new ResourceNotFoundException("Id recieved does not exixst: " + id);
        employee.setName(receivedEmployee.getName());
        employee.setDepartment(receivedEmployee.getDepartment());
        employee.setSalary(receivedEmployee.getSalary());
        employeeService.setEmployee(employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id){
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null)
            throw  new ResourceNotFoundException("Id recieved does not exixst: " + id);
        employeeService.deleteEmployee(employee);
        // Json {"deleted: " true/false}
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
