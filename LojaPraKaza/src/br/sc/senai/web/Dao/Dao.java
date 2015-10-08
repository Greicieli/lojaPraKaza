package br.sc.senai.web.Dao;

import java.sql.Connection;
import java.sql.DriverManager;


public abstract class Dao {

	private Connection conn;
	
	public Connection  getConnection(){
	if(conn == null){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
								"jdbc:mysql://localhost/praKaza_db", "root", "");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	return conn;
}

}

