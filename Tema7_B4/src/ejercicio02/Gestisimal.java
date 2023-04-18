package ejercicio02;

public class Gestisimal {
	
	private int codigo;
	
	private String descripcion;
	
	private double precioCompra;
	
	private double precioVenta;
	
	private int stock;
	
	public Gestisimal () {
		
		super();

	}

	public Gestisimal(int codigo, String descripcion, double precioCompra, double precioVenta, int stock) {

		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.stock = stock;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String toString () {
		
		String res;
		
		res= "Código= "+this.codigo+"\n"
				+ "Descripción= "+ this.descripcion+"\n"
				+ "Precio de compra= "+this.precioCompra+"\n"
				+ "Precio de venta= "+this.precioVenta+"\n"
				+ "Unidades en stock= "+this.stock;
				
		
		return res;
	}

}
