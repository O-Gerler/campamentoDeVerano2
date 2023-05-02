package modeloDTO;

public class Mascota {
	private int id;
	private String nombre;
	private int numChip;
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
	public int getNumChip() {
		return numChip;
	}
	public void setNumChip(int numChip) {
		this.numChip = numChip;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
}
