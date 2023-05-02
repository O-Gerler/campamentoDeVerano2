package modeloDTO;

import java.util.Date;

public class ActividadesPorGrupo {
	private Actividad actividad;
	private Grupo grupo;
	private String hora;
	private Date fecha;
	
	public Actividad getActividad() {
		return actividad;
	}
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public ActividadesPorGrupo(Actividad actividad, Grupo grupo, String hora, Date fecha) {
		super();
		this.actividad = actividad;
		this.grupo = grupo;
		this.hora = hora;
		this.fecha = fecha;
	}
	public ActividadesPorGrupo() {
		super();
	}
	
}
