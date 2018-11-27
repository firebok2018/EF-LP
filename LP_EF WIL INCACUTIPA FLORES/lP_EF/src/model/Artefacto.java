package model;

public class Artefacto {
	private int id;
	private String nombre;
	private int stock;
	private double precio;
	private String fecha;
	public Artefacto(int id, String nombre, int stock, double precio, String fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
		this.fecha = fecha;
	}
	
	public Artefacto(String nombre, int stock, double precio, String fecha) {
		super();
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
