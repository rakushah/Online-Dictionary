/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class Main {
    
    public static void main(String[] args){
        String query="select * from entries";
        ExecuteQuery ex=new ExecuteQuery();
        try {
            ResultSet result=ex.retrieveData(query);
            while(result.next()){
                System.out.println(result.getString("word"));
            }
            result.close();
        } catch (SQLException ex1) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }
}
