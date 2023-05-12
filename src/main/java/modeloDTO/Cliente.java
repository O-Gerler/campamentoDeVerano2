package modeloDTO;

import java.util.ArrayList;

public class Cliente extends Usuario{
	private Grupo grupo;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
