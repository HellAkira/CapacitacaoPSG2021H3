package Servico;

	import java.util.Date;
	import java.util.List;

	import Dominio.SubCategoria;
	import repositorio.SubCategoriaRepositorio;
	
	public class SubCategoriaServico {

		private SubCategoriaRepositorio repo;

		public SubCategoriaServico(SubCategoriaRepositorio repo) {
				
			this.repo = repo;

		}

		public void alterar(SubCategoria subCat) {
			
			repo.update(subCat);
			
		}

		public void excluir(SubCategoria subCat) {
			
			repo.delete(subCat.getSubCategoriaID());
			
		}

		public void excluirPorID(Integer id) {
			repo.delete(id);
		}
		
		public void inserir(SubCategoria subCategoria) {
			
			SubCategoria c = new SubCategoria(subCategoria.getSubCategoriaID(), subCategoria.getCategoriaID(), subCategoria.getDescricao(), new Date());
			repo.create(c);
			
		}

		public List<SubCategoria> listar() {
			
			return repo.readAll();
			
		}

		public SubCategoria obter(Integer id) {

			return repo.read(id);

		}

	}


