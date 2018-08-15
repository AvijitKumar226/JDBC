package com.caps.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStudent {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student sid");
		int si=Integer.parseInt(sc.nextLine());
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2. Get the DB connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/capsV3_db?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);
			String sql="delete from students_info where sid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, si);
			int j=pstmt.executeUpdate();
			if(j>0)
			{
				System.out.println("Successfully deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			/*
			 * 5. Close all the JDBC Objects
			 */

			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			

		}
		
		
		
	}

}
