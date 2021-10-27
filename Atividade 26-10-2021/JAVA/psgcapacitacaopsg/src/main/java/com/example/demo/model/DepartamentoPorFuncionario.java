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
@Table(name = "DepartamentoPorFuncionario")
public class DepartamentoPorFuncionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DepartamentoPorFuncionarioID")
	private Integer departamentoPorFuncionarioID;

	@Column(name = "DepartamentoID")
	private Integer departamentoID;

	@Column(name = "FuncionarioID")
	private Integer funcionarioID;

	@Column(name = "DataInicio")
	@Temporal(value = TemporalType.DATE)
	private Date dataInicio;

	@Column(name = "DataFim")
	@Temporal(value = TemporalType.DATE)
	private Date dataFim;

	DepartamentoPorFuncionario() {

	}

	public DepartamentoPorFuncionario(Integer departamentoPorFuncionarioID, Integer departamentoID, Integer funcionarioID,
			Date dataInicio, Date dataFim) {
		super();
		this.departamentoPorFuncionarioID = departamentoPorFuncionarioID;
		this.departamentoID = departamentoID;
		this.funcionarioID = funcionarioID;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Integer getDepartamentoPorFuncionarioID() {
		return departamentoPorFuncionarioID;
	}

	public void setDepartamentoPorFuncionarioID(Integer departamentoPorFuncionarioID) {
		this.departamentoPorFuncionarioID = departamentoPorFuncionarioID;
	}

	public Integer getDepartamentoID() {
		return departamentoID;
	}

	public void setDepartamentoID(Integer departamentoID) {
		this.departamentoID = departamentoID;
	}

	public Integer getFuncionarioID() {
		return funcionarioID;
	}

	public void setFuncionarioID(Integer funcionarioID) {
		this.funcionarioID = funcionarioID;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public String toString() {
		return "Departamento [departamentoPorFuncionarioID=" + departamentoPorFuncionarioID + ", departamentoID="
				+ departamentoID + ", funcionarioID=" + funcionarioID + ", dataInicio=" + dataInicio + ", dataFim="
				+ dataFim + "]";
	}

}
