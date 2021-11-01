package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Mesoregiao")
public class Mesoregiao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer mesoregiaoID;

	@Column(name = "DESCR")
	private String descricao;

	@Column(name = "SiglaUF")
	private String siglaUF;
	
	public Mesoregiao() {
		
	}
	
	public Mesoregiao(Integer mesoregiaoID, String descricao, String siglaUF) {
		super();
		this.mesoregiaoID = mesoregiaoID;
		this.descricao = descricao;
		this.siglaUF = siglaUF;
	}

	@Override
	public String toString() {
		return "Mesoregiao [mesoregiaoID=" + mesoregiaoID + ", descricao=" + descricao + ", siglaUF=" + siglaUF + "]";
	}

	public Integer getMesoregiaoID() {
		return mesoregiaoID;
	}

	public void setMesoregiaoID(Integer mesoregiaoID) {
		this.mesoregiaoID = mesoregiaoID;
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