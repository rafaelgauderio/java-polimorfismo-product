package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	
	private Date dataFabricacao;
	private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");	
	
	public UsedProduct () {
		
	}

	public UsedProduct(String name, Double price, Date dataFabricacao) {
		super(name, price);
		this.dataFabricacao = dataFabricacao;		
	}	
	
	
	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	@Override
	public String etiquetaDePreco() {
		return name + " (used) r$ " +  String.format("%.2f", price) + " (Data de fabricação: "+ sdf1.format(dataFabricacao) + ")";
	}

	
	
	

}
