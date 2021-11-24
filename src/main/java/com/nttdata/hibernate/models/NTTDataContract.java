package com.nttdata.hibernate.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.nttdata.hibernate.persistence.AbstractEntity;

/**
 * Esta clase define el objeto NTTDataContract el cual representa un contrato.
 * @author David César Fernández Aliseda
 * @version 17/11/21/A
 */


@Entity
@Table(name = "NTTDATA_CONTRACT")

public class NTTDataContract extends AbstractEntity implements Serializable{
	private Long idContract;
	private Date validityDate;
	private Date expirationDate;
	private Integer mensualPrice;
	private NTTDataClient client;

	public NTTDataContract() {
		super();
	}

	// Id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdContract() {
		return idContract;
	}

	public void setIdContract(Long idContract) {
		this.idContract = idContract;
	}

	// ValidityDate
	@Column(name = "CONTRACT_VALIDITYDATE", nullable = false)
	public Date getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}

	// ExpirationDate
	@Column(name = "CONTRACT_EXPIRATIONDATE", nullable = false)
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	// MonthValue
	@Column(name = "CONTRACT_MONTHVALUE", nullable = false)
	public Integer getMensualPrice() {
		return mensualPrice;
	}

	public void setMensualPrice(Integer monthValue) {
		this.mensualPrice = monthValue;
	}

	// Client
	@ManyToOne
	//@Column(name = "CONTRACT_CLIENT", nullable = false)
	@JoinColumn(name = "FK_CLIENTID")
	public NTTDataClient getClient() {
		return client;
	}

	public void setClient(NTTDataClient client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "NTTDataContract [idContract=" + idContract + ", validityDate=" + validityDate + ", expirationDate="
				+ expirationDate + ", monthValue=" + mensualPrice + ", clientID=" + client + "]";
	}

	@Transient
	public Class<?> getClase() {
		return NTTDataContract.class;
	}
	
}
