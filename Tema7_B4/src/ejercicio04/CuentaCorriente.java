package ejercicio04;

public class CuentaCorriente {
	
	private String dNI;
	private String nombre;
	private int saldo;
	enum Sexo {masculino, femenino};
	private Sexo sexo;
	
	/**
	 * 
	 * @param dNI
	 * @param saldo
	 */
	public CuentaCorriente(String dNI, int saldo) {
	
		this.dNI = dNI;
		this.saldo = saldo;
	}

	/**
	 * 
	 * @param dNI
	 * @param nombre
	 * @param sexo
	 */
	public CuentaCorriente(String dNI, String nombre, String sexo) {

		this.dNI = dNI;
		this.nombre = nombre;
		
		//para pasar algún atributo como un tipo hay que utilizar valueOf
		this.sexo= Sexo.valueOf(sexo);
		
	}
	
	public String getdNI() {
		return dNI;
	}

	public void setdNI(String dNI) {
		this.dNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	/**
	 * 
	 * @param saldoR
	 * @return
	 */
	public int sacarDinero(int saldoR) {
		
		if (this.saldo>saldoR) {
			
			this.saldo-=saldoR;
		}
		
		return this.saldo;
		
	}
	
	/**
	 * 
	 * @param ingreso
	 * @return
	 */
	public int ingresoDinero (int ingreso) {
		
		this.saldo+=ingreso;
		
		return this.saldo;
	}
	
	/**
	 * 
	 */
	public String toString() {
		
		String result;
		
		result= "DNI: "+this.dNI+" ;\n"
				+"titular de la cuenta: "+this.nombre+" ;\n"
				+"sexo del titular: "+this.sexo;
				
		return result;
	}
	
	
	
	
	

}
