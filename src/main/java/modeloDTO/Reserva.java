package modeloDTO;

import java.util.Date;

public class Reserva {
	private Parcela parcela;
	private Usuario usuario;
	private Date fecha_ingreso;
	private Date fecha_salida;
	private boolean ocupado;
	
	public Parcela getParcela() {
		return parcela;
	}
	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario cliente) {
		this.usuario = cliente;
	}
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public Date getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public Reserva(Parcela parcela, Cliente cliente, Date fecha_ingreso, Date fecha_salida) {
		super();
		this.parcela = parcela;
		this.usuario = cliente;
		this.fecha_ingreso = fecha_ingreso;
		this.fecha_salida = fecha_salida;
	}
	public Reserva() {
		super();
	}
	
}
