package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Microregiao")
public class Microregiao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer microregiaoID;

	@Column(name = "DESCR")
	private String descricao;

	@Column(name = "SiglaUF")
	private String siglaUF;
	
	public Microregiao() {
		
	}
	
	public Microregiao(Integer microregiaoID, String descricao, String siglaUF) {
		super();
		this.microregiaoID = microregiaoID;
		this.descricao = descricao;
		this.siglaUF = siglaUF;
	}

	@Override
	public String toString() {
		return "Microregiao [microregiaoID=" + microregiaoID + ", descricao=" + descricao + ", siglaUF=" + siglaUF + "]";
	}

	public Integer getMicroregiaoID() {
		return microregiaoID;
	}

	public void setMicroregiaoID(Integer microregiaoID) {
		this.microregiaoID = microregiaoID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSiglaUF() {
		return siglaUF;
	}

	public void setSiglaUF(String siglaUF) {
		this.siglaUF = siglaUF;
	}
	
}