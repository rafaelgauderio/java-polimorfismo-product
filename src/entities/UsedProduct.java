package entities;

import java.util.Date;

public class UsedProduct extends Product {
	
	private Date dataFabricacao;
	
	
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
		return name + " (used) r$ " +  String.format("%.2f", price) + " (Data de fabricação: "+ dataFabricacao + ")";
	}

	
	
	

}
