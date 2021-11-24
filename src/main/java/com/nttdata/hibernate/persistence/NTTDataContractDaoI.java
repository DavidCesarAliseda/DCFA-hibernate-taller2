package com.nttdata.hibernate.persistence;

import java.util.List;

import com.nttdata.hibernate.models.NTTDataContract;
/**
 * Taller 2 - Hibernate
 * 
 * DAO de tabla NTTDataContract
 * 
 * @author David Cesar Fernandez Aliseda
 *
 */public interface NTTDataContractDaoI extends CommonDaoI<NTTDataContract>{
	
	public List<NTTDataContract> searchByClientId(final Long idCliente);
	
	public List<NTTDataContract> searchByClientIdCriteria(final Long idCliente);
	
	public List<NTTDataContract> searchByPriceCriteria(final Integer mensualPrice);
	
}
