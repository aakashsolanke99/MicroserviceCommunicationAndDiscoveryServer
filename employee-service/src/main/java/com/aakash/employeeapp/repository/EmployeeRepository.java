package com.aakash.employeeapp.repository;

import com.aakash.employeeapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
