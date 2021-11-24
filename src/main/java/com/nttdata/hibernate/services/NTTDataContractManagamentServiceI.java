package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.models.NTTDataClient;
import com.nttdata.hibernate.models.NTTDataContract;

public interface NTTDataContractManagamentServiceI {
	public void insertNewContract(final NTTDataContract newContract);

	public void updateContract(final NTTDataContract updatedContract);

	public void deleteContract(final NTTDataContract deletedContract);

	public NTTDataContract searchById(final Long contractId);

	public List<NTTDataContract> searchByIDCLient(final Long clientId);

	public List<NTTDataContract> searchAll();

	public List<NTTDataContract> searchByClientIdCriteria(final Long idCliente);
	
	public List<NTTDataContract> searchByPriceCriteria(final Integer mensualPrice);
}
