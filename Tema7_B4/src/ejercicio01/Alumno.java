package ejercicio01;

public class Alumno {
	
	/**
	 * Atributo de tipo String que guarda el nombre del alumno.
	 */
	private String nombre;
	
	/**
	 * Atributo de tipo double que fuarda la nota media de cada alumno.
	 */
	private double notaMedia;

	/**
	 * Construtor por defecto Alumno.
	 */
	public Alumno() {
		
	}

	/**
	 * Constructor Alumno con parámetros.
	 * 
	 * @param nombre
	 * @param notaMedia
	 */
	public Alumno(String nombre, double notaMedia) {
		
		if (nombre!=null&& nombre.length()!=0) {
			
			this.nombre = nombre;	
		}
	
		if (notaMedia>=0&&notaMedia<=10) {
			
			this.notaMedia = notaMedia;
		}
		
	}

	/**
	 * Función get nombre.
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Función set del atributo nombre
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
	
		if (nombre!=null&& nombre.length()!=0) {
			
			this.nombre = nombre;	
		}
	}

	/**
	 * Función get del atributo notaMedia.
	 * 
	 * @return notaMedia
	 */
	public double getNotaMedia() {
		return notaMedia;
	}

	/**
	 * Método set del atributo notaMedia.
	 * 
	 * @param notaMedia
	 */
	public void setNotaMedia(double notaMedia) {
		
		if (notaMedia>0&& notaMedia<=10) {
			
			this.notaMedia = notaMedia;
		}
		
	}
	
	public String toString() {

		String result="";

		result = this.nombre+": "+this.notaMedia;

		return result;
	}
	
	
}
