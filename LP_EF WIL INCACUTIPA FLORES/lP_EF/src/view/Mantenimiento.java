package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conec.ConexionArtefacto;
import model.Artefacto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Mantenimiento extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTextField txtFecha;
	private JTextField txtFiltro;
	private JButton btnFiltrar;
	private JLabel lblPrecio;
	private JLabel lblStock;
	private JLabel lblFecha;
	private JLabel lblFiltrarPorStock;
	private JScrollPane scrollPane;
	private JTable table;

	ConexionArtefacto con= new ConexionArtefacto();
	private JButton btnGrabar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mantenimiento frame = new Mantenimiento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mantenimiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 25, 46, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(92, 22, 325, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(92, 53, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(92, 84, 86, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(92, 115, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		txtFecha.setText(fecha());
		
		txtFiltro = new JTextField();
		txtFiltro.setBounds(160, 157, 86, 20);
		contentPane.add(txtFiltro);
		txtFiltro.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(284, 156, 89, 23);
		contentPane.add(btnFiltrar);
		
		lblPrecio = new JLabel("precio:");
		lblPrecio.setBounds(24, 56, 46, 14);
		contentPane.add(lblPrecio);
		
		lblStock = new JLabel("Stock:");
		lblStock.setBounds(24, 87, 46, 14);
		contentPane.add(lblStock);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(24, 118, 46, 14);
		contentPane.add(lblFecha);
		
		lblFiltrarPorStock = new JLabel("Filtrar por stock");
		lblFiltrarPorStock.setBounds(24, 160, 126, 14);
		contentPane.add(lblFiltrarPorStock);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 197, 536, 212);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(363, 53, 89, 23);
		contentPane.add(btnGrabar);
		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrar(arg0);
		}
	}
	String nom(){
		return txtNombre.getText();
	}
	double pre(){
		return Double.parseDouble(txtPrecio.getText());
	}
	int s(){
		return Integer.parseInt(txtStock.getText());
	}
	int filtro(){
		return Integer.parseInt(txtFiltro.getText());
	}
	String f(){
		return txtFecha.getText();
	}
	String fecha(){
		Date d = new Date();
		DateFormat f= DateFormat.getDateInstance();
		//System.out.println(f1.format(d));
		return f.format(d);
	}
	protected void actionPerformedBtnFiltrar(ActionEvent arg0) {
		con.ls_m(table,filtro());
	}
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		Artefacto x= new Artefacto(nom(), s(), pre(), f());
		con.add_Art(x);
		listar();
	}
	void listar(){
		con.ListarArtefacto(table);
	}
}
