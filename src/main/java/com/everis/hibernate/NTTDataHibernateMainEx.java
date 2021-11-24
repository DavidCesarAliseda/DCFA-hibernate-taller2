package com.everis.hibernate;

import java.util.Date;

import org.hibernate.Session;

import com.nttdata.hibernate.models.NTTDataClient;
import com.nttdata.hibernate.models.NTTDataContract;
import com.nttdata.hibernate.services.NTTDataClientManagementServiceI;
import com.nttdata.hibernate.services.NTTDataClientManagementServiceImpl;
import com.nttdata.hibernate.services.NTTDataContractManagamentServiceI;
import com.nttdata.hibernate.services.NTTDataContractManagamentServiceImpl;

/**
 * Taller2 - Hibernate - 
 * 
 * Clase principal
 * 
 * @author David Cesar Fernandez Aliseda
 *
 */
public class NTTDataHibernateMainEx {

	/**
	 * MÃ©todo principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final NTTDataClientManagementServiceI clientService = new NTTDataClientManagementServiceImpl(session);
		final NTTDataContractManagamentServiceI contractService = new NTTDataContractManagamentServiceImpl(session);

		// Auditoría.
		final String updatedUser = "NTTDATACLIENT_SYS";
		final Date updatedDate = new Date();
		
		//Clientes
		NTTDataClient cliente1 = new NTTDataClient();
		cliente1.setName("Pepe");
		cliente1.setSurname1("Garcia");
		cliente1.setSurname2("Fernandez");
		cliente1.setDni("69854712F");
		cliente1.setUpdatedUser(updatedUser);
		cliente1.setUpdatedDate(updatedDate);
		clientService.insertNewClient(cliente1);
		
		NTTDataClient cliente2 = new NTTDataClient();
		cliente2.setName("Jose");
		cliente2.setSurname1("Cardo");
		cliente2.setSurname2("Gonzalez");
		cliente2.setDni("69854712J");
		cliente2.setUpdatedUser(updatedUser);
		cliente2.setUpdatedDate(updatedDate);
		clientService.insertNewClient(cliente2);
		
		
		
		//Contratos
		NTTDataContract contrato1 = new NTTDataContract();
		contrato1.setValidityDate(new Date());
		contrato1.setExpirationDate(new Date());
		contrato1.setMensualPrice(160);
		contrato1.setClient(cliente2);
		contrato1.setUpdatedUser(updatedUser);
		contrato1.setUpdatedDate(updatedDate);
		contractService.insertNewContract(contrato1);
		
		NTTDataContract contrato2 = new NTTDataContract();
		contrato2.setValidityDate(new Date());
		contrato2.setExpirationDate(new Date());
		contrato2.setMensualPrice(72);
		contrato2.setClient(cliente2);
		contrato2.setUpdatedUser(updatedUser);
		contrato2.setUpdatedDate(updatedDate);
		contractService.insertNewContract(contrato2);
		
		//Servicios
		contrato2.setValidityDate(new Date(2022, 01, 26));
		contractService.updateContract(contrato2);
		
		System.out.println(contractService.searchById((long) contrato1.getIdContract()));
		
		System.out.println(contractService.searchAll());
		
		System.out.println(contractService.searchByIDCLient((long) cliente2.getId()));
		
		System.out.println("Consulta criteria Nombre y apellidos: "+clientService.searchByNameAndSurnameCriteria(cliente2.getName(), cliente2.getSurname1(), cliente2.getSurname2()));
		System.out.println("Consulta criteria DNI: "+clientService.searchByDNICriteria(cliente1.getDni()));
		
		System.out.println("Consulta criteria Contratos: "+ contractService.searchByClientIdCriteria(cliente2.getId()));
		System.out.println("Consulta criteria Contratos menores a 100: "+ contractService.searchByPriceCriteria(200));
		
		contractService.deleteContract(contrato1);
		
		session.close();
	}

}
