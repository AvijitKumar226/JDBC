package com.caps.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class UpdatePassword {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		Scanner sc=new Scanner(System.in);
		int sid1;
		String oldPass;
		System.out.println("Enter the new Password");
		String npass1=sc.nextLine();
		System.out.println("Repeat the new Password");
		String npass2=sc.nextLine();
		if(npass1.equals(npass2))
		{
			System.out.println("Enter the sid");
			sid1=Integer.parseInt(sc.nextLine());
			System.out.println("Enter the old password");
			oldPass=sc.nextLine();
			
			
			
			try {
				java.sql.Driver driverRef;
				driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
				
				String dbUrl="jdbc:mysql://localhost:3306/capsV3_db"
						+ "?user=root&password=root";
				con = DriverManager.getConnection(dbUrl);
				
				String sql = "update students_info set password=? where sid=? and password=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,npass1);
				pstmt.setInt(2, sid1);
				pstmt.setString(3,oldPass);
				int c=pstmt.executeUpdate();
				if(c>0)
				{
					System.out.println("Update Successful");
				}
				else
				{
					System.out.println("Note Successful");
				}
				
				
			} catch (SQLException e) {
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
		else
		{
			try {
				
				throw new UpdatePasswordException("Wrong Password");
			}
			catch(UpdatePasswordException e)
			{
				System.out.println(e.getMsg());
			}
			
		}
		
		
		
		
	}
}
