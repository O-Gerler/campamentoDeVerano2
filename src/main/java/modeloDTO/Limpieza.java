package modeloDTO;

public class Limpieza extends Personal {
	private Zona zona;

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Limpieza(Zona zona) {
		super();
		this.zona = zona;
	}

	public Limpieza() {
		super();
	}

}
