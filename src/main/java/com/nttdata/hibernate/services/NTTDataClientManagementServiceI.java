package com.nttdata.hibernate.services;
import java.util.List;

import com.nttdata.hibernate.models.NTTDataClient;


public interface NTTDataClientManagementServiceI {


	public void insertNewClient(final NTTDataClient newClient);

	public void updateClient(final NTTDataClient updatedClient);

	public void deleteClient(final NTTDataClient deletedClient);

	public NTTDataClient searchById(final Long clientId);

	public List<NTTDataClient> searchByNameAndSurname(final String name, final String surname1);

	public List<NTTDataClient> searchAll();
	
	public List<NTTDataClient> searchByNameAndSurnameCriteria(final String name, final String surname1, final String surname2);
	
	public NTTDataClient searchByDNICriteria(String dni);
}
