package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DepartamentoID")
	private Integer departamentoID;

	@Column(name = "Descricao")
	private String descricao;

	@Column(name = "Inclusao")
	@Temporal(value = TemporalType.DATE)
	private Date inclusao;
	
	public Departamento() {
		
	}
	
	public Departamento(Integer departamentoID, String descricao, Date inclusao) {
		super();
		this.departamentoID = departamentoID;
		this.descricao = descricao;
		this.inclusao = inclusao;
	}

	public Integer getDepartamentoID() {
		return departamentoID;
	}

	public void setDepartamentoID(Integer departamentoID) {
		this.departamentoID = departamentoID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getInclusao() {
		return inclusao;
	}

	public void setInclusao(Date inclusao) {
		this.inclusao = inclusao;
	}

	@Override
	public String toString() {
		return "Departamento [departamentoID=" + departamentoID + ", descricao=" + descricao + ", inclusao=" + inclusao
				+ "]";
	}
	
	
	
}