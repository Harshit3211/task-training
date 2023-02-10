package com.licious.taskA.model;

import javax.persistence.Id;
import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


enum Gender{
    M,
    F;
}

@Entity
@Table(name="employees",schema ="employees" )
public class Employees implements Comparable<Employees> {
    @Id
    @Column(name = "emp_no",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date birth_date;
    private String first_name;
    private String last_name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date hire_date;
    private Double employee_score;

//    @OneToMany(mappedBy = "emp",cascade = CascadeType.ALL)
//    private Set<DeptEmp> deptEmp = new HashSet<>();

    public Employees(){
    }

    public Employees(int id, Date birth_date, String first_name, String last_name, Gender gender, Date hire_date, Double employee_score) {
        this.id = id;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.hire_date = hire_date;
        this.employee_score = employee_score;
    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {this.birth_date = birth_date;}

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getHire_date() {return hire_date;}

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Double getEmployee_score() {
        return employee_score;
    }

    public void setEmployee_score(Double employee_score) {
        this.employee_score = employee_score;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public int compareTo(Employees o) {
           return this.id-o.id;
    }
}
