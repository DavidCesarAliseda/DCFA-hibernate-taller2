package com.nttdata.hibernate.persistence;

import java.util.List;

import com.nttdata.hibernate.models.NTTDataClient;
/**
 * Taller 2 - Hibernate
 * 
 * DAO de tabla NTTDataClient
 * 
 * @author David Cesar Fernandez Aliseda
 *
 */
public interface NTTDataClientDaoI extends CommonDaoI<NTTDataClient> {

	public List<NTTDataClient> searchByNameAndSurname(final String name, final String surname1);
	
	public List<NTTDataClient> searchByNameAndSurnameCriteria(final String name, final String surname1, final String surname2);
	
	public NTTDataClient searchByDNICriteria(String dni);
}
