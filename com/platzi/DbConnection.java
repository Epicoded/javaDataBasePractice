package com.platzi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
	
	String url = "C:/Users/MXI02003132A/Desktop/UnaDM/Base/mensajes.db";

    public Connection get_connection(){
        Connection conection = null;
        try{
            conection = DriverManager.getConnection("jdbc:sqlite:"+url);
           
        }catch(SQLException e) {
            System.out.println(e);
        }
        return conection;
        
    }
    
}

