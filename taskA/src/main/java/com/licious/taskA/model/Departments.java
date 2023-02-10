package com.licious.taskA.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="departments",schema ="employees" )
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_no",nullable = false)
    private String id;
    @Column(name="dept_name")
    private String dept;

    @OneToMany(mappedBy = "dept",cascade = CascadeType.ALL)
    private Set<DeptEmp> deptEmp = new HashSet<>();

    public Departments() {
    }

    public Departments(String id, String dept) {
        this.id = id;
        this.dept = dept;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
