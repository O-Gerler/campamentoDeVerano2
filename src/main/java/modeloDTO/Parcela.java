package modeloDTO;

public class Parcela {
	private int id;
	private Zona zona;
	private Tipo tipo;
	private Grupo grupo;
	private boolean limpia;
	
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
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public boolean getLimpia() {
		return limpia;
	}
	public void setLimpia(boolean limpia) {
		this.limpia = limpia;
	}
}
