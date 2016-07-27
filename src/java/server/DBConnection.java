/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Owner
 */
public class DBConnection {
    Connection c = null;
	
	public DBConnection(){
		 try {
		      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/entries","root","root");
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}

	public Connection getC() {
		return c;
	}
}
