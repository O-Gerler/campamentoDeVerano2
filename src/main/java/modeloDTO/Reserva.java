package modeloDTO;

import java.util.Date;

public class Reserva {
	private Parcela parcela;
	private Cliente cliente;
	private Date fecha_ingreso;
	private Date fecha_salida;
	
	public Parcela getParcela() {
		return parcela;
	}
	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	
	public Reserva(Parcela parcela, Cliente cliente, Date fecha_ingreso, Date fecha_salida) {
		super();
		this.parcela = parcela;
		this.cliente = cliente;
		this.fecha_ingreso = fecha_ingreso;
		this.fecha_salida = fecha_salida;
	}
	public Reserva() {
		super();
	}
	
}
