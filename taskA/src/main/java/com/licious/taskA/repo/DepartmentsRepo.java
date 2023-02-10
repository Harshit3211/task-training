package com.licious.taskA.repo;

import com.licious.taskA.model.Departments;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value = "departmentsRepo")
public interface DepartmentsRepo extends JpaRepository<Departments,String> {
      public Departments findByDept(String dept);
}
