package principal.controladores;

import principal.entidades.Usuario;

public class ControladorUsuario extends SuperControlador {
	private static ControladorUsuario instance = null;

	public ControladorUsuario() {
		super("contrato", Usuario.class);
		// TODO Auto-generated constructor stub
	}

	public static ControladorUsuario getInstance() {
		if (instance == null) {
			instance = new ControladorUsuario();
	}
		return instance;
	}
}
