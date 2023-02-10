package com.licious.taskA.repo;

import com.licious.taskA.model.Departments;
import com.licious.taskA.model.DeptEmp;
import com.licious.taskA.model.Pk;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier(value = "deptEmpRepo")
public interface DeptEmpRepo extends JpaRepository<DeptEmp, Pk> {
    public List<DeptEmp> findAllByDept(Departments dept, Sort sort);
}
