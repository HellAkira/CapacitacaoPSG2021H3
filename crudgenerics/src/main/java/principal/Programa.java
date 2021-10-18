package principal;

import java.util.Date;

import dominio.Categoria;
import dominio.Produto;
import dominio.SubCategoria;
import servico.CategoriaServico;
import servico.ProdutoServico;
import servico.SubCategoriaServico;

public class Programa {

	public static void main(String[] args) {

		testaCat();
		testaSub();
		testaPro();
		
	}

	private static void testaCat() {

		CategoriaServico serv = new CategoriaServico("exemplo-jpa");
		
		Categoria teste = new Categoria(null, "teste", new Date());

		serv.inserir(teste);
		
		for (Categoria teste2 : serv.listar()) {

			System.out.println(teste2);

		}
		
		serv.dispose();

		

	}

	private static void testaSub() {

		SubCategoriaServico serv = new SubCategoriaServico("exemplo-jpa");
		SubCategoria teste = new SubCategoria(null, 1, "teste sub", new Date());

		serv.inserir(teste);

		for (SubCategoria teste2 : serv.listar()) {

			System.out.println(teste2);

		}
		serv.dispose();
	}

	private static void testaPro() {

		ProdutoServico serv = new ProdutoServico("exemplo-jpa");
		Produto teste = new Produto(null, 1, 1, "teste pro", new Date());

		serv.inserir(teste);

		for (Produto teste2 : serv.listar()) {

			System.out.println(teste2);

		}
		
		serv.dispose();

	}

}
