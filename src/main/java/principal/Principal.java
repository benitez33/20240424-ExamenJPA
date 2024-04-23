package principal;

import javax.swing.JFrame;


import principal.vistas.PanelTabla;

public class Principal extends JFrame{

	static Principal instance = null;
	PanelTabla pt = PanelTabla.getInstance();
	

	public static Principal getInstance() {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	

	public Principal() {
		super("Gestion de bankonter");
		this.setBounds(0,0,800,600);

		
		

		
		this.getContentPane().add(pt);
		
	}


	public static void main(String[] args) {

		Principal.getInstance().setVisible(true);
		
	}

}
