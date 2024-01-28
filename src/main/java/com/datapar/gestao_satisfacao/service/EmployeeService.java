package com.datapar.gestao_satisfacao.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.datapar.gestao_satisfacao.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(UUID id);
    void deleteEmployeeById(UUID id);
    Page<Employee> findPaginated(int pageNo, int pageSize);

}
