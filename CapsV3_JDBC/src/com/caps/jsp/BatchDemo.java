package com.caps.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDemo { 
	public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt=null;
		
		
		
		//1. Load the driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/capsv3_db"
					+ "?user=root&password=root";
		//2.get connection via a driver	
			con=DriverManager.getConnection(dburl);
			
		//3.Issue sql query via con
			String query1="insert into students_info values(9,'Simmi','M','y','sim')";
			String query2="insert into students_info values(10,'Siddhart','Kumar','n','sid')";
			String query3="insert into students_info values(11,'Pallav','Kumar','n','Pal')";
			stmt=con.createStatement();
			//creating batch
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			stmt.addBatch(query3);
			//4.Processing
			int[] noOfRowsEffected=stmt.executeBatch();
		
			for (int i : noOfRowsEffected) {
				System.out.println("Effected Row  "+i);
				
			}
			stmt.clearBatch();
			
			
			

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5.Close All JDBC Connection

			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			

		}
		
	}

}
