package modeloDTO;

public class Tipo {
	private int id;
	private String nombre;
	private int cantidad_personas;
	private String descripcion;
	
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
	public int getCantidad_personas() {
		return cantidad_personas;
	}
	public void setCantidad_personas(int cantidad_personas) {
		this.cantidad_personas = cantidad_personas;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
