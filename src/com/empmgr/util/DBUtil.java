package com.empmgr.util;

import java.sql.*;
import java.util.concurrent.CopyOnWriteArrayList;

//      封装JDBC工具类
public class DBUtil {

//    连接数据库
    public static Connection getConnection(){
        Connection conn = null;
        //数据库信息
        String URL="jdbc:mysql://localhost:3306/stumgr";
        String USER = "root";
        String PASSWORD = "221388544";
        try {
//            加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(URL,USER,PASSWORD);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
//      关闭数据库
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs){
        try{
            if(rs != null){
                stmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try{
            if(stmt != null){
                stmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try{
            if(conn != null){
                stmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

//   重构一下
    private DBUtil(){

    }

//    因为更新数据需要用到executeUpdate，将DML操作提取出来，就不用写太多重复的代码
    public static  int executeUpdate(String sql , Object[] params){
        int n =0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for(int i =0 ; i<params.length ;i++){
                pstmt.setObject(i+1,params[i]);
            }
            n = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeConnection(conn,pstmt,null);
        }
        return  n;
    }
}
