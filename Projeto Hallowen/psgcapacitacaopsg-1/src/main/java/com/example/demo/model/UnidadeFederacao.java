package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_UnidadesFederacao")
public class UnidadeFederacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer unidadeFederacaoID;

	@Column(name = "DESCR")
	private String descricao;

	@Column(name = "SiglaUF")
	private String siglaUF;
	
	@Column(name = "RegiaoBrasil")
	private String regiaoBrasil;

	public UnidadeFederacao(Integer unidadeFederacaoID, String descricao, String siglaUF, String regiaoBrasil) {
		super();
		this.unidadeFederacaoID = unidadeFederacaoID;
		this.descricao = descricao;
		this.siglaUF = siglaUF;
		this.regiaoBrasil = regiaoBrasil;
	}
	
	public UnidadeFederacao(){}
	
	@Override
	public String toString() {
		return "UnidadeFederacao [unidadeFederacaoID=" + unidadeFederacaoID + ", descricao=" + descricao + ", siglaUF="
				+ siglaUF + ", regiaoBrasil=" + regiaoBrasil + "]";
	}

	public Integer getUnidadeFederacaoID() {
		return unidadeFederacaoID;
	}

	public void setUnidadeFederacaoID(Integer unidadeFederacaoID) {
		this.unidadeFederacaoID = unidadeFederacaoID;
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

	public String getRegiaoBrasil() {
		return regiaoBrasil;
	}

	public void setRegiaoBrasil(String regiaoBrasil) {
		this.regiaoBrasil = regiaoBrasil;
	}
	

}