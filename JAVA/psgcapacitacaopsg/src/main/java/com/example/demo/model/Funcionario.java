package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "Funcionario")
public class Funcionario {

	@Id
	@Column(name = "FuncionarioID")
	private Integer funcionarioID;
	
	@Column(name = "Chave")
	private Long chave;

	@Column(name = "Nome")
	private String nome;

	@Column(name = "Sobrenome")
	private String sobrenome;

	@Column(name = "Sexo")
	private char sexo;

	@Column(name = "Email")
	private String email;

	@Column(name = "CTPS")
	private String ctps;

	@Column(name = "NumeroCTPS")
	private long numeroCTPS;

	@Column(name = "SerieCTPS")
	private Integer serieCTPS;

	@Column(name = "PaisID")
	private Integer paisID;

	@Column(name = "Admissao")
	private Date admissao;

	@Column(name = "Nascimento")
	private Date nascimento;
	
	@Column(name = "Inclusao", nullable = true)
	@Temporal(value = TemporalType.DATE)
	private Date inclusao;
	
	public Funcionario() {
		
	}
	

	public Funcionario(Integer funcionarioID, Long chave, String nome, String sobrenome, char sexo, String email,
			String ctps, long numeroCTPS, Integer serieCTPS, Integer paisID, Date admissao, Date nascimento,
			Date inclusao) {
		super();
		this.funcionarioID = funcionarioID;
		this.chave = chave;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.email = email;
		this.ctps = ctps;
		this.numeroCTPS = numeroCTPS;
		this.serieCTPS = serieCTPS;
		this.paisID = paisID;
		this.admissao = admissao;
		this.nascimento = nascimento;
		this.inclusao = inclusao;
	}




	public Integer getFuncionarioID() {
		return funcionarioID;
	}

	public void setFuncionarioID(Integer funcionarioID) {
		this.funcionarioID = funcionarioID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public long getNumeroCTPS() {
		return numeroCTPS;
	}

	public void setNumeroCTPS(long numeroCTPS) {
		this.numeroCTPS = numeroCTPS;
	}

	public Integer getSerieCTPS() {
		return serieCTPS;
	}

	public void setSerieCTPS(Integer serieCTPS) {
		this.serieCTPS = serieCTPS;
	}

	public Integer getPaisID() {
		return paisID;
	}

	public void setPaisID(Integer paisID) {
		this.paisID = paisID;
	}

	public Date getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Date getInclusao() {
		return inclusao;
	}

	public void setInclusao(Date inclusao) {
		this.inclusao = inclusao;
	}

	
	public Long getChave() {
		return chave;
	}


	public void setChave(Long chave) {
		this.chave = chave;
	}


	@Override
	public String toString() {
		return "Funcionario [funcionarioID=" + funcionarioID + ", chave=" + chave + ", nome=" + nome + ", sobrenome="
				+ sobrenome + ", sexo=" + sexo + ", email=" + email + ", ctps=" + ctps + ", numeroCTPS=" + numeroCTPS
				+ ", serieCTPS=" + serieCTPS + ", paisID=" + paisID + ", admissao=" + admissao + ", nascimento="
				+ nascimento + ", inclusao=" + inclusao + "]";
	}


	

}