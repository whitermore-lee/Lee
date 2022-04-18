package com.empmgr.dao.impl;

import com.empmgr.dao.EmployeeDao;
import com.empmgr.entity.Employee;
import com.empmgr.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDaoimpl implements EmployeeDao {
    @Override
    public int save(Employee emp){
//        定义一个变量，返回成功增加n变为1

//        int n =0;
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//
//        try {
////        连接数据库
//            conn = DBUtil.getConnection();
//            String sqlsrt = "insert  into employee values(null,?,?,?,?,?,?,?)";
//            pstmt = conn.prepareStatement(sqlsrt);
////            发送sql命令
//
//            pstmt.setString(1, emp.geteName());
//            pstmt.setString(2,emp.getJob());
//            pstmt.setInt(3,emp.getMgr());
//            pstmt.setDate(4,new java.sql.Date(emp.getHireDate().getTime()));
//            pstmt.setDouble(5,emp.getSal());
//            pstmt.setDouble(6,emp.getComm());
//            pstmt.setInt(7,emp.getDeptNo());
//            n= pstmt.executeUpdate();
//
//        }catch (SQLException e){
//            e.printStackTrace();
//        }finally {
////                    关闭数据库
//            DBUtil.closeConnection(conn,pstmt,null);
//        }

//        封装了execute update代码，重新写一下添加方法
        String sql = "insert  into employee values(null,?,?,?,?,?,?,?)";
//        将增加的对象放到数组中
        Object [] parms={emp.geteName(),emp.getJob(),emp.getMgr(),emp.getHireDate(),emp.getSal(),emp.getComm(),emp.getDeptNo()};
        return  DBUtil.executeUpdate(sql,parms);
    }

    @Override
    public int delete(int empno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int n = 0;
        try{
            //2.获取连接
            conn =DBUtil.getConnection();


            //3.创建Statement
            String sql = "delete from employee where empno = ?";
            pstmt = conn.prepareStatement(sql);


            //4.使用Statement发送SQL命令并得到结果
            pstmt.setInt(1,empno);
            n = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            DBUtil.closeConnection(conn,pstmt,null);

        }

        //返回数据
        return n;
    }

    @Override
    public int update(Employee empno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int n = 0;
        try{
            //2.获取连接
            conn =DBUtil.getConnection();
            //3.创建Statement
            String sql = "update employee set job = ?,sal = ? where empno = ?";
            pstmt = conn.prepareStatement(sql);
            //4.使用Statement发送SQL命令并得到结果
            pstmt.setString(1,empno.getJob());
            pstmt.setDouble(2,empno.getSal());
            pstmt.setInt(3,empno.getEmpNo());
            n = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            DBUtil.closeConnection(conn,pstmt,null);
        }
        //返回数据
        return n;
    }

    /*
    查找全部员工列表
     */
    @Override
    public List<Employee> findAll() {
        Connection conn = null; //数据库连接
//        建一个List，将对象封装到list后返回到前台
        List<Employee> emplist = new ArrayList<Employee>();
        Statement stmt =null;  //语句传送
        ResultSet rs = null;  //结果集，之后遍历到list数组里返回
        String sqlstr = "select  * from  employee";  //查询语句
        try {
            conn = DBUtil.getConnection(); //打开数据库连接
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlstr);
            while (rs.next()){
                int empNo = rs.getInt("empno");
                String eName = rs.getString("ename");
                String job = rs.getString("job");
                int mgr = rs.getInt("mgr");
                Date hireDate = rs.getDate("hiredate");
                Double sal = rs.getDouble("sal");
                Double comm = rs.getDouble("comm");
                int deptNo = rs.getInt("deptno");
//                将数据封装在对象employee中
                Employee employee = new Employee(empNo,eName,job,mgr,hireDate,sal,comm,deptNo);
//                将对象封装在list数组中
                emplist.add(employee);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn,stmt,rs); //关闭资源
        }
        return emplist;
    }

    /*
    通过id查找员工
     */
    @Override
    public Employee findByid(int empno) {
//        创建一个Employee对象
        String sql = "Select * from  employee where  empno = " + empno ;
        Employee employee = null;
        Connection conn = null;
        Statement stmt= null;
        ResultSet rs = null;
//        打开数据库连接
        try {
            conn = DBUtil.getConnection(); //打开数据库连接
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {  //如果结果集里有数据的话，取出数据，返回对象
                String ename = rs.getString(2);
                String job = rs.getString(3);
                int mgr = rs.getInt(4);
                Date hireDate = rs.getDate(5);
                Double sal = rs.getDouble(6);
                Double comm = rs.getDouble(7);
                int deptNo = rs.getInt(8);
                employee = new Employee(empno, ename, job, mgr, hireDate, sal, comm, deptNo);
            }
//            封装对象
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn,stmt,rs); //关闭资源
        }
        return employee;
    }
}
