package entities;

public class ImportedProduct extends Product {
	
	private Double taxaAlfandega;
	
	public ImportedProduct () {
		
	}
	
	public ImportedProduct (String name, Double price, Double taxaAlfandega) {
		super(name, price);
		this.taxaAlfandega = taxaAlfandega;
		
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}
	
	public Double precoTotal () {
		
		return super.price + this.getTaxaAlfandega();
	}
	
	@Override
	public String etiquetaDePreco () {
		
		return name + " r$ " + String.format("%.2f", price) + " (Taxa de Alfândega: " + String.format("%.2f", this.taxaAlfandega) + ")";
	}
	
	

}
