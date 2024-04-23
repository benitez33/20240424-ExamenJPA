package principal.vistas;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import principal.controladores.ControladorContrato;
import principal.controladores.ControladorUsuario;
import principal.controladores.DatosDeTabla;
import principal.entidades.Contrato;
import principal.entidades.Usuario;

public class PanelTabla extends JPanel {

	private static final long serialVersionUID = 1L;
	private static PanelTabla instance = null;
	private JTable tablaUsuarios;
	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();

	public static PanelTabla getInstance() {
		if (instance == null) {
			instance = new PanelTabla();
		}

		return instance;
	}

	/**
	 * Create the panel.
	 */
	public PanelTabla() {
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		this.dtm = getDefaultTableModelNoEditable();
		tablaUsuarios = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(tablaUsuarios);

		tablaUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int indiceFilaSel = tablaUsuarios.getSelectedRow()+1;
				Contrato usuSelec = (Contrato) ControladorContrato.getInstance().find(indiceFilaSel);
				
				PanelGestion panelGestion = new PanelGestion(usuSelec);
				JScrollPane scrollPane2 = new JScrollPane(panelGestion);
				splitPane.setRightComponent(scrollPane2);
				splitPane.setResizeWeight(0.2);

			}
		});

		splitPane.setLeftComponent(scrollPane);
	}
	
	public void actualizarTabla(Contrato c) {
	    datosEnTabla = DatosDeTabla.getDatosDeTabla();
	    int f = tablaUsuarios.getSelectedRow();
	    
	    
	    this.datosEnTabla[f][0] = c.getId();
	    this.datosEnTabla[f][1] = c.getIdTipoContrato();
	    this.datosEnTabla[f][2] = c.getDescripcion();
	    this.datosEnTabla[f][3] = c.getIdUsuario();
	    this.datosEnTabla[f][4] = c.getSaldo();
	    this.datosEnTabla[f][5] = c.getLimite();
	    this.datosEnTabla[f][6] = c.getFechaFirma();
	    
	    dtm.fireTableDataChanged(); 
	}

	
	
	private DefaultTableModel getDefaultTableModelNoEditable () {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			
			/**
			 * 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column != 1) {
					return false;
				}
				return true;
			}
		};
		return dtm;
	}

	public Object[][] getDatosEnTabla() {
		return datosEnTabla;
	}

	public void setDatosEnTabla(Object[][] datosEnTabla) {
		this.datosEnTabla = datosEnTabla;
	}

}
