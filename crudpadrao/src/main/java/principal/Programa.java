package principal;

import java.util.Date;
import Dominio.*;
import Servico.*;
import repositorio.*;

public class Programa {

	public static void main(String[] args) {

		testaCat();
		testaSub();
	}

	private static void testaCat() {

		CategoriaRepositorio repo = new CategoriaRepositorio("exemplo-jpa");
		CategoriaServico serv = new CategoriaServico(repo);
		
		Categoria teste = new Categoria(null, "teste", new Date());

		serv.inserir(teste);
		
		for (Categoria teste2 : serv.listar()) {

			System.out.println(teste2);

		}
		

		repo.dispose();

	}

	private static void testaSub() {

		SubCategoriaRepositorio repo = new SubCategoriaRepositorio("exemplo-jpa");
		SubCategoriaServico serv = new SubCategoriaServico(repo);
		SubCategoria teste = new SubCategoria(null, 1, "teste sub", new Date());

		serv.inserir(teste);

		for (SubCategoria teste2 : serv.listar()) {

			System.out.println(teste2);

		}

		repo.dispose();

	}

	private static void testaPro() {

		ProdutoRepositorio repo = new ProdutoRepositorio("exemplo-jpa");
		ProdutoServico serv = new ProdutoServico(repo);
		Produto teste = new Produto(null, 1, 1, "teste pro", new Date());

		serv.inserir(teste);

		for (Produto teste2 : serv.listar()) {

			System.out.println(teste2);

		}

		repo.dispose();

	}

}
