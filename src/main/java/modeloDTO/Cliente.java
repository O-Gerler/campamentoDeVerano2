package modeloDTO;

import java.util.ArrayList;

public class Cliente extends Usuario{
	private ArrayList<Mascota> mascotas = new ArrayList<>();
	private Grupo grupo;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public ArrayList<Mascota> getMascotas() {
		return mascotas;
	}

	public void agregarMascota(Mascota mascota) {
		mascotas.add(mascota);
	}
}
