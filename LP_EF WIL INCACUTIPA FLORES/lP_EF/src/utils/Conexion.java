package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	public Connection getConetiun(){
		
		String database="modelo";
		String url="jdbc:mysql://localhost:3306/"+database;
		String user="root";
		String pwr= "mysql";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con= DriverManager.getConnection(url,user,pwr);
				
					System.out.println("Conectado");
					
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("ERROR DE CONECCIÓN");
				JOptionPane.showMessageDialog(null, "La conexión a la base de datos falló.",null,0);
			}
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
			return null;
		}
	}

}
