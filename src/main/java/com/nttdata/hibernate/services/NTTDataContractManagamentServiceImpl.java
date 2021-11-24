package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernate.models.NTTDataClient;
import com.nttdata.hibernate.models.NTTDataContract;
import com.nttdata.hibernate.persistence.NTTDataClientDaoImpl;
import com.nttdata.hibernate.persistence.NTTDataContractDaoI;
import com.nttdata.hibernate.persistence.NTTDataContractDaoImpl;

public class NTTDataContractManagamentServiceImpl implements NTTDataContractManagamentServiceI {

	private NTTDataContractDaoI contractDao;

	public NTTDataContractManagamentServiceImpl(Session session) {
		this.contractDao = new NTTDataContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(NTTDataContract newContract) {
		if (newContract != null && newContract.getIdContract() == null) {

			// Insercción del nuevo jugador.
			contractDao.insert(newContract);
		}
	}

	@Override
	public void updateContract(NTTDataContract updatedContract) {
		// Verificación de nulidad e inexistencia.
		if (updatedContract != null && updatedContract.getIdContract() != null) {

			// Insercción del nuevo jugador.
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(NTTDataContract deletedContract) {
		// Verificación de nulidad e inexistencia.
		if (deletedContract != null && deletedContract.getIdContract() != null) {

			// Insercción del nuevo jugador.
			contractDao.delete(deletedContract);
		}

	}

	
	@Override
	public NTTDataContract searchById(Long contractId) {
		
		NTTDataContract contract = null;

		if (contract == null) {
			contract = contractDao.searchById(contractId);
		}

		return contract;
	}

	@Override
	public List<NTTDataContract> searchByIDCLient(Long idCliente) {
		List<NTTDataContract> contractList = new ArrayList<NTTDataContract>();
		
		contractList = contractDao.searchByClientId(idCliente);
		return contractList;
	}

	@Override
	public List<NTTDataContract> searchAll() {
		List<NTTDataContract> contractList = new ArrayList<NTTDataContract>();
		contractList = contractDao.searchAll();
		return contractList;
	}

	@Override
	public List<NTTDataContract> searchByClientIdCriteria(Long idCliente) {
		
		List<NTTDataContract> contractList = new ArrayList<NTTDataContract>();
		if(idCliente != null) {
			contractList = contractDao.searchByClientIdCriteria(idCliente);
		}
		return contractList;
	}

	@Override
	public List<NTTDataContract> searchByPriceCriteria(Integer mensualPrice) {
		
		List<NTTDataContract> contractList = new ArrayList<NTTDataContract>();
		
		if(mensualPrice != null) {
			contractList = contractDao.searchByPriceCriteria(mensualPrice);
		}
		return contractList;
	}

}
