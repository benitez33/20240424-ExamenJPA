package principal.vistas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;

import principal.controladores.ControladorContrato;
import principal.controladores.ControladorUsuario;
import principal.entidades.Contrato;
import principal.entidades.Usuario;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelGestion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfDescripcion;
	private JTextField jtfSaldo;
	private JTextField jtfLimite;
	private JTextField jtfFecha;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdbtnCuentaBancaria;
	JRadioButton rdbtnTarjetaCredito;
	JRadioButton rdbtnTarjetaDebito;
	JRadioButton rdbtnPrestamo;
	JComboBox<Usuario> jcbUsuario;

	/**
	 * Create the panel.
	 */
	public PanelGestion(Contrato c) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestinDeContratos = new JLabel("Gestión de contratos");
		lblGestinDeContratos.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblGestinDeContratos = new GridBagConstraints();
		gbc_lblGestinDeContratos.gridwidth = 4;
		gbc_lblGestinDeContratos.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinDeContratos.gridx = 0;
		gbc_lblGestinDeContratos.gridy = 0;
		add(lblGestinDeContratos, gbc_lblGestinDeContratos);
		
		JLabel lblID = new JLabel("Id:");
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.anchor = GridBagConstraints.EAST;
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 1;
		add(lblID, gbc_lblID);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		rdbtnCuentaBancaria = new JRadioButton("Cuenta bancaria");
		buttonGroup.add(rdbtnCuentaBancaria);
		GridBagConstraints gbc_rdbtnCuentaBancaria = new GridBagConstraints();
		gbc_rdbtnCuentaBancaria.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCuentaBancaria.gridx = 1;
		gbc_rdbtnCuentaBancaria.gridy = 2;
		add(rdbtnCuentaBancaria, gbc_rdbtnCuentaBancaria);
		
		rdbtnTarjetaCredito = new JRadioButton("Tarjeta crédito");
		buttonGroup.add(rdbtnTarjetaCredito);
		GridBagConstraints gbc_rdbtnTarjetaCredito = new GridBagConstraints();
		gbc_rdbtnTarjetaCredito.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTarjetaCredito.gridx = 2;
		gbc_rdbtnTarjetaCredito.gridy = 2;
		add(rdbtnTarjetaCredito, gbc_rdbtnTarjetaCredito);
		
		JLabel lblTipoContrato = new JLabel("Tipo de contrato:");
		GridBagConstraints gbc_lblTipoContrato = new GridBagConstraints();
		gbc_lblTipoContrato.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoContrato.gridx = 0;
		gbc_lblTipoContrato.gridy = 3;
		add(lblTipoContrato, gbc_lblTipoContrato);
		
		rdbtnTarjetaDebito = new JRadioButton("Tarjeta débito");
		buttonGroup.add(rdbtnTarjetaDebito);
		GridBagConstraints gbc_rdbtnTarjetaDebito = new GridBagConstraints();
		gbc_rdbtnTarjetaDebito.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTarjetaDebito.gridx = 1;
		gbc_rdbtnTarjetaDebito.gridy = 3;
		add(rdbtnTarjetaDebito, gbc_rdbtnTarjetaDebito);
		
		rdbtnPrestamo = new JRadioButton("Préstamo");
		buttonGroup.add(rdbtnPrestamo);
		GridBagConstraints gbc_rdbtnPrestamo = new GridBagConstraints();
		gbc_rdbtnPrestamo.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPrestamo.gridx = 2;
		gbc_rdbtnPrestamo.gridy = 3;
		add(rdbtnPrestamo, gbc_rdbtnPrestamo);
		
		JLabel lblDescripcion = new JLabel("Descripción:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 5;
		add(lblDescripcion, gbc_lblDescripcion);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 2;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 5;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 6;
		add(lblUsuario, gbc_lblUsuario);
		
		jcbUsuario = new JComboBox();
		GridBagConstraints gbc_jcbUsuario = new GridBagConstraints();
		gbc_jcbUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jcbUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbUsuario.gridx = 1;
		gbc_jcbUsuario.gridy = 6;
		add(jcbUsuario, gbc_jcbUsuario);
		
		JButton btnGestionarUsuario = new JButton("Gestionar usuario");
		btnGestionarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog dialogo = new JDialog();
				// El usuario no puede redimensionar el diálogo
				dialogo.setResizable(true);
				// título del díalogo
				dialogo.setTitle("Título");
				// Introducimos el panel creado sobre el diálogo
				dialogo.setContentPane(new PanelDialog());
				// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
				dialogo.pack();
				// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
				dialogo.setModal(true);
				// Centro el di�logo en pantalla
				dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
						(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
				// Muestro el di�logo en pantalla
				dialogo.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnGestionarUsuario = new GridBagConstraints();
		gbc_btnGestionarUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_btnGestionarUsuario.gridx = 2;
		gbc_btnGestionarUsuario.gridy = 6;
		add(btnGestionarUsuario, gbc_btnGestionarUsuario);
		
		JLabel lblSaldo = new JLabel("Saldo (€):");
		GridBagConstraints gbc_lblSaldo = new GridBagConstraints();
		gbc_lblSaldo.anchor = GridBagConstraints.EAST;
		gbc_lblSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaldo.gridx = 0;
		gbc_lblSaldo.gridy = 7;
		add(lblSaldo, gbc_lblSaldo);
		
		jtfSaldo = new JTextField();
		GridBagConstraints gbc_jtfSaldo = new GridBagConstraints();
		gbc_jtfSaldo.gridwidth = 2;
		gbc_jtfSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSaldo.gridx = 1;
		gbc_jtfSaldo.gridy = 7;
		add(jtfSaldo, gbc_jtfSaldo);
		jtfSaldo.setColumns(10);
		
		JLabel lblLimite = new JLabel("Limite (€):");
		GridBagConstraints gbc_lblLimite = new GridBagConstraints();
		gbc_lblLimite.anchor = GridBagConstraints.EAST;
		gbc_lblLimite.insets = new Insets(0, 0, 5, 5);
		gbc_lblLimite.gridx = 0;
		gbc_lblLimite.gridy = 8;
		add(lblLimite, gbc_lblLimite);
		
		jtfLimite = new JTextField();
		GridBagConstraints gbc_jtfLimite = new GridBagConstraints();
		gbc_jtfLimite.gridwidth = 2;
		gbc_jtfLimite.insets = new Insets(0, 0, 5, 5);
		gbc_jtfLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLimite.gridx = 1;
		gbc_jtfLimite.gridy = 8;
		add(jtfLimite, gbc_jtfLimite);
		jtfLimite.setColumns(10);
		
		JLabel lblFechaDeFirma = new JLabel("Fecha de firma:");
		GridBagConstraints gbc_lblFechaDeFirma = new GridBagConstraints();
		gbc_lblFechaDeFirma.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeFirma.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeFirma.gridx = 0;
		gbc_lblFechaDeFirma.gridy = 9;
		add(lblFechaDeFirma, gbc_lblFechaDeFirma);
		
		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.gridwidth = 2;
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 9;
		add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar(c);
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 10;
		add(btnGuardar, gbc_btnGuardar);
		
		setUsuario(c);


	}
	
	/**
	 * 
	 */
	public void setUsuario(Contrato e) {
		this.jtfId.setText(String.valueOf(e.getId()));		
		if (e.getIdTipoContrato() == 1) {
			this.rdbtnCuentaBancaria.setSelected(true);
		}
		if (e.getIdTipoContrato() == 2) {
			this.rdbtnTarjetaDebito.setSelected(true);
		}
		if (e.getIdTipoContrato() == 3 ) {
			this.rdbtnTarjetaCredito.setSelected(true);
		}
		if (e.getIdTipoContrato() == 4) {
			this.rdbtnPrestamo.setSelected(true);
		}
		this.jtfDescripcion.setText(e.getDescripcion());
//		this.jcbUsuario.setSelectedItem();
		seleccionarUsuario(e.getIdUsuario());
		this.jtfSaldo.setText(String.valueOf(e.getSaldo()));
		this.jtfLimite.setText(String.valueOf(e.getLimite()));
		this.jtfFecha.setText(dateToString(e.getFechaFirma()));


	}
	
	public static boolean tieneFormatoFecha(String texto) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false); // Esto hace que la validación sea estricta

	    try {
	        Date fecha = sdf.parse(texto);
	        return true; // Si la cadena se puede parsear como fecha, entonces tiene el formato correcto
	    } catch (ParseException e) {
	        return false; // Si hay una excepción al parsear, significa que no tiene el formato correcto
	    }
	}
	
	
	
	public static Date deStringADate(String texto) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 
	    try {
	        Date fecha = sdf.parse(texto);
	        return fecha; // Si la cadena se puede parsear como fecha, entonces tiene el formato correcto
	    } catch (ParseException e) {
	    	JOptionPane.showMessageDialog(null, "Error, la fecha no tiene un formato valido");
	        return null; // Si hay una excepción al parsear, significa que no tiene el formato correcto
	    }
	}
	
	public static String dateToString(Date fecha) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    return sdf.format(fecha);
	}
	
	private void cargarTodosUsuarios() {
		List<Usuario> l = (List<Usuario>) new ControladorUsuario().getInstance().findAll();
		for (Usuario o : l) {
			this.jcbUsuario.addItem(o);
		}

	}
	
	public void seleccionarUsuario(int id) {
		cargarTodosUsuarios();
		for (int i = 0; i < this.jcbUsuario.getItemCount(); i++) {
			if (this.jcbUsuario.getItemAt(i).getId() == id) {
				this.jcbUsuario.setSelectedIndex(i);
			}
		}
	}
	
	public void guardar(Contrato e) {
		if (this.jtfId.getText().isEmpty()) {
			if (isDescripcionValido()) {
				if (tieneFormatoFecha(this.jtfFecha.getText())) {
				if (esLimiteFloat()) {
					if (esSaldoFloat()) {
						if (rdbtnCuentaBancaria.isSelected()) {
							e.setIdTipoContrato(1);;
						}
						if (rdbtnTarjetaDebito.isSelected()) {
							e.setIdTipoContrato(2);;
						}
						if (rdbtnTarjetaCredito.isSelected()) {
							e.setIdTipoContrato(3);;
						}
						if (rdbtnPrestamo.isSelected()) {
							e.setIdTipoContrato(4);;
						}
						e.setDescripcion(this.jtfDescripcion.getText());
						e.setIdUsuario((int) this.jcbUsuario.getSelectedItem());
						e.setSaldo(Float.valueOf(this.jtfSaldo.getText()));
						e.setLimite(Float.valueOf(this.jtfLimite.getText()));
						e.setFechaFirma(deStringADate(this.jtfFecha.getText()));
						
					    ControladorContrato.getInstance().update(e);

					    JOptionPane.showMessageDialog(null, "Se han guardado los datos del estudiante");

					    PanelTabla.getInstance().actualizarTabla(e);
					}
					else {
						JOptionPane.showMessageDialog(null, "Error al guardar, el stock no es válido");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al guardar, el precio no es válido");
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al guardar, el codigo no es válido");
			}
			
				}
			
		}
	}
	
	public boolean esSaldoFloat() {
		try {
			Float.parseFloat(this.jtfSaldo.getText());
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	public boolean esLimiteFloat() {
		try {
			Float.parseFloat(this.jtfLimite.getText());
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	private boolean isDescripcionValido() {
		String str = this.jtfDescripcion.getText();

		if (str.length() <= 4) {
			return false;

		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}

		}
		return true;

	}

}
