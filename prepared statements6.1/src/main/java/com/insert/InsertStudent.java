package com.insert;

import java.sql.*;

public class InsertStudent {
	 public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/prepared_statement";
	        String user = "root";
	        String password = "Ashok@mysql";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url, user, password);

	            String query = "UPDATE student SET email=? WHERE id=?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, "newemail@example.com");
	            ps.setInt(2, 1);
	            
	            
	            int rows = ps.executeUpdate();
	            System.out.println(rows + " record updated successfully!");


	            

	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
