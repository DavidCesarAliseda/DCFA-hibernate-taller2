package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nttdata.hibernate.models.NTTDataClient;
import com.nttdata.hibernate.models.NTTDataContract;
/**
 * Taller 2 - Hibernate
 * 
 * DAO implementado de tabla NTTDataContract
 * 
 * @author David Cesar Fernandez Aliseda
 *
 */
public class NTTDataContractDaoImpl extends CommonDaoImpl<NTTDataContract> implements NTTDataContractDaoI {

	private Session session;

	public NTTDataContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NTTDataContract> searchByClientId(Long idCliente) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza contratos en función del id.
		final List<NTTDataContract> clientsList = session
				.createQuery("FROM NTTDataContract WHERE client.id=" + idCliente).list();

		return clientsList;
	}

	@Override
	public List<NTTDataContract> searchByClientIdCriteria(Long idCliente) {

		// Consulta
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NTTDataContract> cquery = cb.createQuery(NTTDataContract.class);
		final Root<NTTDataContract> rootC = cquery.from(NTTDataContract.class);

		// Where
		final Predicate pId = cb.equal(rootC.<Long>get("client").get("id"), idCliente);

		// Consulta select
		cquery.select(rootC).where(pId);

		// Ejecucion de consulta
		final List<NTTDataContract> contracts = session.createQuery(cquery).getResultList();

		return contracts;
	}

	@Override
	public List<NTTDataContract> searchByPriceCriteria(Integer mensualPrice) {
		
		// Consulta
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NTTDataContract> cquery = cb.createQuery(NTTDataContract.class);
		final Root<NTTDataContract> rootC = cquery.from(NTTDataContract.class);

		// Where
		final Predicate pPrice = cb.lt(rootC.<Integer>get("mensualPrice"), mensualPrice);

		// Consulta select
		cquery.select(rootC).where(pPrice);

		// Ejecucion de consulta
		final List<NTTDataContract> contracts = session.createQuery(cquery).getResultList();

		return contracts;
	}

}
