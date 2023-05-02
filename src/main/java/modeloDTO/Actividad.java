package modeloDTO;

public class Actividad {
	private int id;
	private Zona zona;
	private String nombre;
	private int cantidad_max;
	private int edad_min;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Zona getZona() {
		return zona;
	}
	public void setZona(Zona zona) {
		this.zona = zona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad_max() {
		return cantidad_max;
	}
	public void setCantidad_max(int cantidad_max) {
		this.cantidad_max = cantidad_max;
	}
	public int getEdad_min() {
		return edad_min;
	}
	public void setEdad_min(int edad_min) {
		this.edad_min = edad_min;
	}
	public Actividad(Integer id, Zona zona, String nombre, Integer cantidad_max, Integer edad_min) {
		super();
		this.id = id;
		this.zona = zona;
		this.nombre = nombre;
		this.cantidad_max = cantidad_max;
		this.edad_min = edad_min;
	}
	public Actividad() {
		super();
	}
}
