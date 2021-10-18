package dominio;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProdutoID")
	private Integer produtoID;

	@Column(name = "CategoriaID")
	private Integer categoriaID;

	@Column(name = "SubCategoriaID")
	private Integer subCategoriaID;

	@Column(name = "Descricao")
	private String descricao;

	@Column(name = "DataInsert")
	private Date dataDeInsercao;

	public Produto() {

	}

	public Produto(Integer produtoID, Integer categoriaID, Integer subCategoriaID, String descricao,
			Date dataDeInsercao) {
		super();
		this.produtoID = produtoID;
		this.categoriaID = categoriaID;
		this.subCategoriaID = subCategoriaID;
		this.descricao = descricao;
		this.dataDeInsercao = dataDeInsercao;
	}

	public Integer getProdutoID() {
		return produtoID;
	}

	public void setProdutoID(Integer produtoID) {
		this.produtoID = produtoID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataDeInsercao() {
		return dataDeInsercao;
	}

	public void setDataDeInsercao(Date dataDeInsercao) {
		this.dataDeInsercao = dataDeInsercao;
	}

	public Integer getCategoriaID() {
		return categoriaID;
	}

	public void setCategoriaID(Integer categoriaID) {
		this.categoriaID = categoriaID;
	}

	public Integer getSubCategoriaID() {
		return subCategoriaID;
	}

	public void setSubCategoriaID(Integer subCategoriaID) {
		this.subCategoriaID = subCategoriaID;
	}

	@Override
	public String toString() {
		return "Produto [produtoID=" + produtoID + ", categoriaID=" + categoriaID + ", subCategoriaID=" + subCategoriaID
				+ ", descricao=" + descricao + ", dataDeInsercao=" + dataDeInsercao + "]";
	}

}