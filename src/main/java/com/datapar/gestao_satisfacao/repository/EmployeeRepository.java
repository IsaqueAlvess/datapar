package com.datapar.gestao_satisfacao.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datapar.gestao_satisfacao.model.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, UUID> {

}
