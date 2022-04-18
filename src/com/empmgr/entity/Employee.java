package com.empmgr.entity;

import java.util.Date;

public class Employee {
    private int empNo;
    private String eName;
    private String job;
    private int mgr;
    private Date hireDate;
    private Double sal;
    private Double comm;
    private int deptNo;

//    构造函数
    public Employee(int empNo, String eName, String job, int mgr, Date hireDate, Double sal, Double comm, int deptNo) {
        this.empNo = empNo;
        this.eName = eName;
        this.job = job;
        this.mgr = mgr;
        this.hireDate = hireDate;
        this.sal = sal;
        this.comm = comm;
        this.deptNo = deptNo;
    }

    public Employee() {
    }

    public Employee(int empNo, String job, Double sal) {
        this.empNo = empNo;
        this.job = job;
        this.sal = sal;
    }
//重构一个没id编号的，毕竟是主键，自增就行了


    public Employee(String eName, String job, int mgr, Date hireDate, Double sal, Double comm, int deptNo) {
        this.eName = eName;
        this.job = job;
        this.mgr = mgr;
        this.hireDate = hireDate;
        this.sal = sal;
        this.comm = comm;
        this.deptNo = deptNo;
    }

    //    toString方法重构
    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", eName='" + eName + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hireDate=" + hireDate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptNo=" + deptNo +
                '}';
    }

//    getter和setter
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }
}


