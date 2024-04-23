package principal.controladores;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import principal.entidades.Contrato;
import principal.entidades.Entidad;
import principal.entidades.Usuario;

public class SuperControlador {

	private static String nombreTabla = "";
	private Class tipoEntidad;
	private static EntityManager em = null;

	public SuperControlador(String nombreTabla, Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}

	/**
	 * 
	 * @return
	 */
	protected static EntityManager getEntityManager() {
		if (em == null) {
			em = Persistence.createEntityManagerFactory("bankonter").createEntityManager();
		}
		return em;
	}

	/**
	 * 
	 * @return
	 */
	public List<? extends Entidad> findAll() {
		return (List<Entidad>) getEntityManager()
				.createNativeQuery("SELECT * FROM " + nombreTabla + ";", this.tipoEntidad).getResultList();

	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Entidad find(int id) {
		EntityManager em;
		try {
			em = getEntityManager();
			Entidad entidad = (Entidad) em.find(this.tipoEntidad, id);
			return entidad;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	

	public void update(Entidad e) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}


}
