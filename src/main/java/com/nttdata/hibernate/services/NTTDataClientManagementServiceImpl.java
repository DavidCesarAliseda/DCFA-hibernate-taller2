package com.nttdata.hibernate.services;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.models.NTTDataClient;
import com.nttdata.hibernate.persistence.NTTDataClientDaoI;
import com.nttdata.hibernate.persistence.NTTDataClientDaoImpl;

public class NTTDataClientManagementServiceImpl implements NTTDataClientManagementServiceI {

	private NTTDataClientDaoI clientDao;

	/**
	 * MÃ©todo constructor
	 */
	public NTTDataClientManagementServiceImpl(Session session) {
		this.clientDao = new NTTDataClientDaoImpl(session);
	}

	@Override
	public void insertNewClient(NTTDataClient newClient) {
		// Verificación de nulidad e inexistencia.
		if (newClient != null && newClient.getId() == null) {

			// Insercción del nuevo jugador.
			clientDao.insert(newClient);
		}

	}

	@Override
	public void updateClient(NTTDataClient updatedClient) {
		// Verificación de nulidad e inexistencia.
		if (updatedClient != null && updatedClient.getId() != null) {

			// Insercción del nuevo jugador.
			clientDao.update(updatedClient);
		}

	}

	@Override
	public void deleteClient(NTTDataClient deletedClient) {
		// Verificación de nulidad e inexistencia.
		if (deletedClient != null && deletedClient.getId() != null) {

			// Insercción del nuevo jugador.
			clientDao.delete(deletedClient);
		}

	}

	@Override
	public NTTDataClient searchById(Long clientId) {
		// Resultado.
		NTTDataClient client = null;

		// Verificación de nulidad.
		if (clientId != null) {

			// Obtención del jugador por ID.
			client = clientDao.searchById(clientId);
		}

		return client;
	}

	@Override
	public List<NTTDataClient> searchAll() {
		List<NTTDataClient> clientList = new ArrayList<NTTDataClient>();
		clientList = clientDao.searchAll();
		return clientList;
	}

	@Override
	public List<NTTDataClient> searchByNameAndSurname(String name, String surname1) {
		// Resultado.
		List<NTTDataClient> clientList = new ArrayList<NTTDataClient>();

		// Obtención de jugadores.
		clientList = clientDao.searchByNameAndSurname(name, surname1);

		return clientList;
	}

	@Override
	public List<NTTDataClient> searchByNameAndSurnameCriteria(String name, String surname1, String surname2) {
		List<NTTDataClient> clientList = new ArrayList<NTTDataClient>();
		if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(surname1) && StringUtils.isNotBlank(surname2)) {

			clientList = clientDao.searchByNameAndSurnameCriteria(name, surname1, surname2);
		}
		
		return clientList;

	}

	@Override
	public NTTDataClient searchByDNICriteria(String dni) {
		NTTDataClient client = new NTTDataClient();
		
		if (StringUtils.isNotBlank(dni)) {

			client = clientDao.searchByDNICriteria(dni);
		}
		
		return client;
	}

}
