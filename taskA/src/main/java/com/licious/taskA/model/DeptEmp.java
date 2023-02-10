package com.licious.taskA.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Id;
@Entity
@Table(name="dept_emp",schema ="employees" )
@IdClass(Pk.class)
public class DeptEmp implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "emp_no",nullable = false)
    private Employees emp;
    @Id
    @ManyToOne
    @JoinColumn(name = "dept_no",nullable = false)
    private Departments dept;
    private Date from_date;
    private Date to_date;

    public DeptEmp(){

    }

    public DeptEmp(Employees emp, Departments dept, Date from_date, Date to_date) {
        this.emp = emp;
        this.dept = dept;
        this.from_date = from_date;
        this.to_date = to_date;
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

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public void setId(Pk id) {
        this.dept = id.getDept();
        this.emp = id.getEmp();
    }

    public Pk getId() {
        return new Pk(
                emp,
                dept
        );
    }
}
