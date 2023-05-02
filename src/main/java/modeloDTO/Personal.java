package modeloDTO;

import java.util.Date;

public class Personal extends Usuario{
	private int director;
	private Date fechaIngreso;

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getDirector() {
		return director;
	}

	public void setDirector(int director) {
		this.director = director;
	}
}
