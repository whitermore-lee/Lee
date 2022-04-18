package com.empmgr.test;

import com.empmgr.dao.EmployeeDao;
import com.empmgr.dao.impl.EmployeeDaoimpl;
import com.empmgr.entity.Employee;
import javafx.scene.input.DataFormat;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test {

//    前台发起请求
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("");
            System.out.println("*****欢迎进入员工管理系统*****");
            System.out.println("\t1.查询所有员工");
            System.out.println("\t2.查询指定编号员工");
            System.out.println("\t3.添加员工信息");
            System.out.println("\t4.修改员工信息");
            System.out.println("\t5.删除员工信息");
            System.out.println("\t6.退出");
            System.out.println("***************************");
            System.out.print("请选择菜单：");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    findAll();
                    break;
                case 2:
                    findByid();
                    break;
                case 3:
                    save();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    System.out.println("谢谢使用");
                    return;
                default:
                    System.out.println("输入错误");
            }
            System.out.println("按任意键继续.........");
            //input.next();
            input.nextLine();
            input.nextLine();
        }while(true);
    }
    /*
    更新
     */

    private static void update() {
//        输入，就修改三个吧
        Scanner input = new Scanner(System.in);
        System.out.println("请输入员工岗位");
        String  job =  input.next();
        System.out.println("请输入员工薪水");
        double  sal =  input.nextDouble();

        System.out.println("请输入员工编号");
        int  empno =  input.nextInt();

        //2.调后台完成修改操作
        Employee emp = new Employee(empno,job,sal);
        EmployeeDao employeeDao = new EmployeeDaoimpl();
        int n = employeeDao.update(emp);


        //3.输出结果
        if(n>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    /*
    删除
     */
    private static void delete() {
       Scanner input = new Scanner(System.in);
        System.out.println("请输入要删除的员工编号");
        int id = input.nextInt();
        EmployeeDao employeeDao = new EmployeeDaoimpl();
        int n=employeeDao.delete(id);
        if(n>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }


    /*
    查找所有员工列表
     */
    private static List<Employee> findAll(){
        EmployeeDao empdao = new EmployeeDaoimpl();

        List<Employee> list = empdao.findAll();
        System.out.println("编号\t姓名\t\t岗位\t\t上级\t入职时间\t\t薪水\t\t补助\t\t部门编号");
        for (Employee employee:list) {
            System.out.println(employee.getEmpNo()+"\t"+employee.geteName()+"\t"+employee.getJob()+"\t"+employee.getMgr()
                    +"\t"+employee.getHireDate()+ "\t"+employee.getSal()+"\t"+employee.getComm()+"\t"+employee.getDeptNo());
        }
        return  list;
    }

    /*
    按照id编号查找员工
     */
    private static void findByid(){
//                输入
        System.out.println("请输入id编号");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
//        调用Dao层
        EmployeeDao employeeDao = new EmployeeDaoimpl();
        Employee  employee =  employeeDao.findByid(id);
//        输出
        if(employee == null){
            System.out.println("没有找到相关信息");
        }else {
        System.out.println("编号\t姓名\t\t岗位\t\t上级\t入职时间\t\t薪水\t\t补助\t\t部门编号");
        System.out.println(employee.getEmpNo()+"\t"+employee.geteName()+"\t"+employee.getJob()+"\t"+employee.getMgr()
                    +"\t"+employee.getHireDate()+ "\t"+employee.getSal()+"\t"+employee.getComm()+"\t"+employee.getDeptNo());        }
    }

    private  static  void  save() {
        System.out.println("请输入你所要添加员工的信息");
        Scanner input = new Scanner(System.in);
        System.out.println("输入员工姓名：");
        String eName = input.nextLine();
        System.out.println("请输入员工工作岗位");
        String job = input.nextLine();
        System.out.println("请输入员工上级编号");
        int mgr = input.nextInt();
        System.out.println("请输入薪水");
        Double sal = input.nextDouble();
        System.out.println("请输入员工每月补助");
        Double comm = input.nextDouble();
        System.out.println("请输入员工部门编号");
        int deptNo = input.nextInt();
        System.out.println("请输入员工入职日期（YYYY-MM-DD）");
        String date = input.next();
//        转格式：将String转为Data
        Date hireDate =null;
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        try {
            hireDate = sdf.parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
        Employee employee =new Employee(eName,job,mgr, hireDate,sal,comm,deptNo);
        EmployeeDao employeeDao = new EmployeeDaoimpl();
        int n = employeeDao.save(employee);
        if(n>0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

}

