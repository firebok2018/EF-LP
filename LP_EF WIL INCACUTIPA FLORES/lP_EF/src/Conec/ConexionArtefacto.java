package Conec;


import java.sql.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Artefacto;
import utils.Conexion;

public class ConexionArtefacto {
	
	public void add_Art(Artefacto x){
		Connection con = null;
		CallableStatement sp= null;
		
		try {
			con= new Conexion().getConetiun();
			sp=con.prepareCall("{ call add_artefacto(?,?,?,?) }");
			sp.setString(1, x.getNombre());
			sp.setInt(2, x.getStock());
			sp.setDouble(3, x.getPrecio());
			sp.setString(4, x.getFecha());
			sp.executeQuery();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getErrorCode()+e.getMessage());
		}finally {
			try {
				con.close();
				sp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getErrorCode()+e.getMessage());
			}
		}
	}
	public void ListarArtefacto(JTable j) {
		Connection con= null;
		CallableStatement sp=null;
		ResultSet rs=null;
		DefaultTableModel modelo= new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Stock");
		modelo.addColumn("Precio");
		modelo.addColumn("Fecha");
		j.setModel(modelo);
		String [] a= new String[6];
		try {
			con= new Conexion().getConetiun();
			String u_sp="{ call ls_art()}";
			sp= con.prepareCall(u_sp);
			rs= sp.executeQuery();
			
			while (rs.next()) {
			
				a[0]=rs.getInt(1)+"";
				a[1]=rs.getString(2);
				a[2]=rs.getInt(3)+""; 
				a[3]=rs.getDouble(4)+"";
				a[4]=rs.getString(5);
				modelo.addRow(a);			
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage()+e.getErrorCode());
			System.out.println("Error de Listado en la tabla");
		}
		
	}
	public void ls_m(JTable s,int x){
		Connection con = null;
		CallableStatement usp=null;
		ResultSet rs= null;
		DefaultTableModel modelo= new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Stock");
		modelo.addColumn("Precio");
		modelo.addColumn("Fecha");
		s.setModel(modelo);
		try {
			con= new Conexion().getConetiun();
			usp= con.prepareCall("call ls_m(?)");
			usp.setInt(1,x);
			rs=usp.executeQuery();
			String [] st= new String[5];
			while(rs.next()){
				st[0]=rs.getInt(1)+"";
				st[1]=rs.getString(2);
				st[2]=rs.getInt(3)+""; 
				st[3]=rs.getDouble(4)+"";
				st[4]=rs.getString(5);
				modelo.addRow(st);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage()+e.getErrorCode());
		}
		
	}
	

}
