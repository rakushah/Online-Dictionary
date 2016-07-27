/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Owner
 */
public class ExecuteQuery {
    Statement stmt = null;
    ResultSet retrievedData;
	public ExecuteQuery(){
	}

	public boolean executeQuery(String query){
		Connection connection;
		try{
			DBConnection obj= new DBConnection();
			//System.out.println(query);
			System.out.println(query);
			connection =obj.getC();//get connection
			connection.setAutoCommit(false);
			//System.out.println("Opened database successfully");

			stmt = connection.createStatement();//create statement to run
		   if( stmt.executeUpdate(query)!=0){
			   //System.out.println("Successfully added");
			   connection.commit();
			  // System.out.println("Successfully commited");
			   return true;
		   }
		   else{
			   return false;
		   }


		}
		catch(Exception e){
			//alert(e.getMessage());
			System.out.println(e.getMessage());
			return false;
		}
		finally{
			//if(!connection.isClosed())connection.close();
			//if(!stmt.isClosed())stmt.close();
			
		}
	}

	public ResultSet retrieveData(String query) throws SQLException{
		try{
			DBConnection obj= new DBConnection();
			//System.out.println(query);
			Connection connection  =obj.getC();
			//connection.setAutoCommit(false);
			//System.out.println("Opened database successfully");

			stmt = connection.createStatement();//create statemnt to run
			retrievedData = stmt.executeQuery( query );
			return retrievedData;


		}
		catch(Exception e){
			
			System.out.println(e.getMessage());
			return null;
		}
		finally{
			//if(connection!=null)connection.close();
			//if(stmt!=null)stmt.close();

		}
	}
}
