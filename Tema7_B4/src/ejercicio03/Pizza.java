package ejercicio03;

public class Pizza {
	
	private int codigo;
	
	enum Size {Mediana, Familiar};
	
	private Size size;
	
	enum Tipo {Margarita, CuatroQuesos, Funghi};
	
	private Tipo tipo;
	
	enum Estado {Pedida, Servida}

	private Estado estado;
	
	public Pizza() {
		super();
		
	}

	public Pizza(int codigo, String size, String tipo) {
		this.codigo = codigo;
		this.size=Size.valueOf(size);
		this.tipo=Tipo.valueOf(tipo);
	
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getSize() {
		return String.valueOf(size);
	}

	public void setSize(String size) {
		this.size =Size.valueOf(size);
	}

	public String getTipo() {
		return String.valueOf(tipo);
	}

	public void setTipo(String tipo) {
		this.tipo = Tipo.valueOf(tipo);
	}

	public String getEstado() {
		return String.valueOf(estado);
	}

	public void setEstado(String estado) {
		this.estado = Estado.valueOf(estado);
	}
	
public String toString () {
		
		String res;
		
		res= "Código= "+this.codigo+"\n"
				+ "Tamaño= "+ this.size+"\n"
				+ "Tipo= "+this.tipo+"\n"
				+ "Estado= "+this.estado+"\n";
				
		return res;
	}
	
	
	

}
