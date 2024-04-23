package principal.controladores;

import java.util.List;

import principal.entidades.Contrato;

public class DatosDeTabla {

	private static Object[][] datos = null;
 	
	
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Descripción", "Saldo", "Límite", "idTipoContrato", "id Usuario", "Fecha firma"};
	}
	
	
	public static Object[][] getDatosDeTabla() {
		if (datos == null) {
			List<Contrato> contrato = (List<Contrato>) ControladorContrato.getInstance().findAll();
			datos = new Object[contrato.size()][11];
			for (int i = 0; i < contrato.size(); i++) {
				Contrato c = contrato.get(i);
				datos[i][0] = c.getId();
				datos[i][1] = c.getDescripcion();
				datos[i][2] = c.getSaldo();
				datos[i][3] = c.getLimite();
				datos[i][4] = c.getIdTipoContrato();
				datos[i][5] = c.getIdUsuario();
				datos[i][6] = c.getFechaFirma();
			}
		}
		
		return datos;
	}

	
	
}
