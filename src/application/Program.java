package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		List<Product> listaProdutos = new ArrayList<Product>();

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Informe a quantidade de produtos: ");
		int numeroProdutos = input.nextInt();

		for (int i = 1; i <= numeroProdutos; i++) {

			System.out.println("Dados do produto #" + i);
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char tipo = input.next().toLowerCase().charAt(0);

			System.out.print("Nome: ");
			input.nextLine(); // consumir a quebra de linha pendente
			String nome = input.nextLine();
			System.out.print("Preço: ");
			Double preco = input.nextDouble();
			input.nextLine(); // consumir a quebra de linha pendente

			if (tipo == 'i' ) {
				System.out.print("Taxa de alfandega: ");
				Double taxaAlfandega = input.nextDouble();
				Product produtoImportado = new ImportedProduct(nome, preco, taxaAlfandega);
				listaProdutos.add(produtoImportado);

			} else if (tipo == 'u') {
				System.out.print("Data de Fabricação (DD/MM/YYYY): ");
				String dataFabricacao = input.nextLine();				
				//String dataFabricacao ="17/12/2005";
				Date data = sdf1.parse(dataFabricacao);
				Product produtoUsado = new UsedProduct(nome, preco, data);
				listaProdutos.add(produtoUsado);
				

			} else if (tipo =='c'){
				Product produtoComum = new Product(nome, preco);
				listaProdutos.add(produtoComum);

			} else {
				System.out.println("Foi informado um valor inválido para o tipo de Produto.\n"
						+ "Os valores possível são Comum, usado ou importado (c/u/i)?\n");
				i--; // para incrementar a variável caso entrar aqui
			}
		}

		System.out.println("\nETIQUETAS DE PREÇO");

		for (Product nickname : listaProdutos) {
			System.out.println(nickname.etiquetaDePreco());
		}

		input.close();

		/*
		 * SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		 * 
		 * Product camiseta = new Product("Camiseta Polo Masculina", 29.90); Product
		 * celular = new UsedProduct("Sansung S20", 900.00, sdf1.parse("17/12/2005"));
		 * Product tablet = new ImportedProduct("Tablet Ipad II",500.00,20.00);
		 * 
		 * 
		 * 
		 * System.out.println("\nETIQUETAS DOS PRODUTOS");
		 * System.out.println(tablet.etiquetaDePreco());
		 * System.out.println(camiseta.etiquetaDePreco());
		 * System.out.println(celular.etiquetaDePreco());
		 * 
		 */

	}

}
