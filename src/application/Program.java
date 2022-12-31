package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");	
		
		Product camiseta = new Product("Camiseta Polo Masculina", 29.90);
		Product celular = new UsedProduct("Sansung S20", 900.00, sdf1.parse("17/12/2005"));			
		Product tablet = new ImportedProduct("Tablet Ipad II",500.00,20.00);
		
		
		System.out.println("\nETIQUETAS DOS PRODUTOS");
		System.out.println(tablet.etiquetaDePreco());
		System.out.println(camiseta.etiquetaDePreco());
		System.out.println(celular.etiquetaDePreco());
		
		

	}

}
