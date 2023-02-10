package com.licious.taskA.model;

import java.io.Serializable;
import java.util.Objects;

public class Pk implements Serializable {
    protected Employees emp;
    protected Departments dept;

    public Pk() {}

    public Pk(Employees emp, Departments dept) {
        this.emp = emp;
        this.dept = dept;
    }

    public Employees getEmp() {
        return emp;
    }

    public void setEmp(Employees emp) {
        this.emp = emp;
    }

    public Departments getDept() {
        return dept;
    }

    public void setDept(Departments dept) {
        this.dept = dept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeptEmp)) return false;
        DeptEmp that = (DeptEmp) o;
        return Objects.equals(emp, that.getEmp()) &&
                Objects.equals(dept, that.getDept());
    }

    @Override
    public int hashCode() {
        return Objects.hash(emp, dept);
    }
}