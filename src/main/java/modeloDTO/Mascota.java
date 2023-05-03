package modeloDTO;

public class Mascota {
	private int id;
	private String nombre;
	private String numChip;
	private String raza;
	
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
	public String getNumChip() {
		return numChip;
	}
	public void setNumChip(String numChip) {
		this.numChip = numChip;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
}
