package com.empmgr.dao;

import com.empmgr.entity.Employee;

import java.util.List;

public interface EmployeeDao {
//    增加
    public  int save(Employee emp);
//    删除
    public int delete(int empno);
//    修改
    public  int update(Employee empno);
//    查询全部
    public List<Employee> findAll();
//    通过id查询
    public  Employee findByid(int empno);
}
