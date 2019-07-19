package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "pass");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public static Student getDetails(String u1, String u2) {
		try {
			Connection c = StudentDao.getConnection();

			PreparedStatement ps = c.prepareStatement("select * from Students where username=? and password=?");

			ps.setString(1, u1);
			ps.setString(2, u2);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s1 = new Student();
				s1.ID = rs.getInt("ID");
				s1.Name = rs.getString("Name");
				s1.dob = rs.getString("dob");
				s1.email = rs.getString("email");
				return s1;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static boolean reg(Student Ob1) {
		try {

			Connection c = StudentDao.getConnection();
			
			PreparedStatement ps = c.prepareStatement("insert into School.Students (Name, email, dob, username, password) values (?,?,?,?,?)");
			ps.setString(1, Ob1.getName());
			ps.setString(2, Ob1.getEmail());
			ps.setString(3, Ob1.getDob());
			ps.setString(4, Ob1.getUsername());
			ps.setString(5, Ob1.getPassword());
			
			boolean rs = ps.execute();
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static int update(Student e){  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps= con.prepareStatement("update School set Name=?,email=?,dob=?,password=? where username=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getEmail());  
            ps.setString(3,e.getDob());  
            ps.setString(4,e.getPassword());  
            ps.setInt(5,e.getUsername());  
              
            status = ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        }            
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from School where id=?");  
            ps.setInt(1,id);  
            status = ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){
        	e.printStackTrace();
        }            
        return status;  
    }  
}
