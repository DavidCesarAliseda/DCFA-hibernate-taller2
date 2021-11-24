package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nttdata.hibernate.models.NTTDataClient;
/**
 * Taller 2 - Hibernate
 * 
 * DAO implementado de tabla NTTDataClient
 * 
 * @author David Cesar Fernandez Aliseda
 *
 */
public class NTTDataClientDaoImpl extends CommonDaoImpl<NTTDataClient> implements NTTDataClientDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public NTTDataClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NTTDataClient> searchByNameAndSurname(String name, String surname1) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza jugadores en función del nombre.
		final List<NTTDataClient> clientsList = session
				.createQuery("FROM NTTDataClient WHERE name= '" + name + "' AND surname1='" + surname1 + "'").list();

		return clientsList;
	}

	@Override
	public List<NTTDataClient> searchByNameAndSurnameCriteria(String name, String surname1, String surname2) {

		// Consulta
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NTTDataClient> cquery = cb.createQuery(NTTDataClient.class);
		final Root<NTTDataClient> rootC = cquery.from(NTTDataClient.class);

		// Where
		final Predicate pNombre = cb.equal(rootC.<String>get("name"), name);
		final Predicate pSurname1 = cb.equal(rootC.<String>get("surname1"), surname1);
		final Predicate pSurname2 = cb.equal(rootC.<String>get("surname2"), surname2);

		// Consulta select
		cquery.select(rootC).where(cb.and(pNombre, pSurname1, pSurname2));

		// Ejecucion de consulta
		final List<NTTDataClient> clientsList = session.createQuery(cquery).getResultList();

		return clientsList;
	}

	@Override
	public NTTDataClient searchByDNICriteria(String dni) {

		// Consulta
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NTTDataClient> cquery = cb.createQuery(NTTDataClient.class);
		final Root<NTTDataClient> rootC = cquery.from(NTTDataClient.class);

		// Where
		final Predicate pDni = cb.equal(rootC.<String>get("dni"), dni);

		// Consulta select
		cquery.select(rootC).where(pDni);

		// Ejecucion de consulta
		final NTTDataClient client = session.createQuery(cquery).getSingleResult();

		return client;
	}

}
