package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Distrito")
public class Distrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer distritoID;

	@Column(name = "DESCR")
	private String descricao;

	@Column(name = "SiglaUF")
	private String siglaUF;
	
	public Distrito() {
		
	}
	
	public Distrito(Integer distritoID, String descricao, String siglaUF) {
		super();
		this.distritoID = distritoID;
		this.descricao = descricao;
		this.siglaUF = siglaUF;
	}

	@Override
	public String toString() {
		return "Distrito [distritoID=" + distritoID + ", descricao=" + descricao + ", siglaUF=" + siglaUF + "]";
	}

	public Integer getDistritoID() {
		return distritoID;
	}

	public void setDistritoID(Integer distritoID) {
		this.distritoID = distritoID;
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