package com.jtarango.hr.service;

import com.jtarango.hr.model.Employee;

import java.util.List;

public interface IEmployeeService {

    public List<Employee> listEmployees();

    public Employee getEmployeeById(Integer employeeId);

    public void setEmployee(Employee employee);

    public void deleteEmployee(Employee employee);
}
