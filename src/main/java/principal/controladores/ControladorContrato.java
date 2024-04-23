package principal.controladores;

import principal.entidades.Contrato;

public class ControladorContrato extends SuperControlador {
	private static ControladorContrato instance = null;

	public ControladorContrato() {
		super("contrato", Contrato.class);
		// TODO Auto-generated constructor stub
	}

	public static ControladorContrato getInstance() {
		if (instance == null) {
			instance = new ControladorContrato();
		}
		return instance;
	}
}
