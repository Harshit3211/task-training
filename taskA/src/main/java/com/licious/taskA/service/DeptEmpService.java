package com.licious.taskA.service;

import com.licious.taskA.model.Departments;
import com.licious.taskA.model.DeptEmp;
import com.licious.taskA.model.Employees;
import com.licious.taskA.repo.DepartmentsRepo;
import com.licious.taskA.repo.DeptEmpRepo;
import com.licious.taskA.repo.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DeptEmpService {
    @Autowired
    private DeptEmpRepo deptEmpRepo;
    @Autowired
    private DepartmentsRepo departmentsRepo;
    @Autowired
    private EmployeesRepo employeesRepo;

    public List<String> getDeptList(){

        List<String> deptList= new ArrayList<>();
        List<Departments> departments= (ArrayList<Departments>) departmentsRepo.findAll();
        for (int i = 0; i < departments.size(); i++) {
            deptList.add(departments.get(i).getDept());
        }
//        departments.forEach(e->{
//            deptList.add(e.getDept());
//        });
        return deptList;
    }

    public Page<Employees> getEmployeesFromDept(String dept,int offSet,int pageSize){

        List<Integer> employeeIds=new ArrayList<>();
        Departments department=departmentsRepo.findByDept(dept);
        List<DeptEmp> deptEmpList= deptEmpRepo.findAllByDept(department,Sort.by(Sort.Direction.ASC,"emp"));
        Pageable pageable = PageRequest.of(offSet,pageSize);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), deptEmpList.size());
        deptEmpList=deptEmpList.subList(start,end);
        deptEmpList.forEach(e->{
            employeeIds.add(e.getEmp().getId());
        });
        List<Employees> employeesData=employeesRepo.findAllById(employeeIds);
        Page<Employees> page = new PageImpl<>(employeesData, pageable, employeesData.size());
        return page;
    }


}
