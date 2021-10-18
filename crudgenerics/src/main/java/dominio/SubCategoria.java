package dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SubCategoriaID")
	private Integer subCategoriaID;

	@Column(name = "CategoriaID")
	private Integer categoriaID;

	@Column(name = "Descricao")
	private String descricao;

	@Column(name = "DataInsert")
	private Date dataDeInsercao;

	public SubCategoria() {

	}

	public SubCategoria(Integer subCategoriaID, Integer categoriaID, String descricao, Date dataDeInsercao) {

		this.subCategoriaID = subCategoriaID;
		this.categoriaID = categoriaID;
		this.descricao = descricao;
		this.dataDeInsercao = dataDeInsercao;
	}

	public Integer getCategoriaID() {
		return categoriaID;
	}

	public void setCategoriaID(Integer categoriaID) {
		this.categoriaID = categoriaID;
	}

	public void setSubCategoriaID(Integer subCategoriaID) {
		this.subCategoriaID = subCategoriaID;
	}

	public Integer getSubCategoriaID() {
		return subCategoriaID;
	}

	public void setsubCategoriaID(Integer subCategoriaID) {
		this.subCategoriaID = subCategoriaID;
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

	@Override
	public String toString() {
		return "SubCategoria [subCategoriaID=" + subCategoriaID + ", categoriaID=" + categoriaID + ", descricao="
				+ descricao + ", dataDeInsercao=" + dataDeInsercao + "]";
	}
}
