package com.licious.taskA.repo;

import com.licious.taskA.model.Employees;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier(value = "employeesRepo")
public interface EmployeesRepo extends JpaRepository<Employees,Integer> {
}
