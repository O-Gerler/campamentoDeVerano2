package modeloDTO;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private String contrasena = "1234";
	private String telefono;
	private Date fechaNacimiento;
	private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
	
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public void agregarVehiculo(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
	}
	
}
