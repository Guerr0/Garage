package Garage;

public class Furgone extends Automobile
{
	private double prezzo;
	private String tipo;
	public Furgone(String targa , String numeroPatente)
	{
		super(targa , numeroPatente);
		this.prezzo = 0.1;
		this.tipo = "FURGONE";
	}

	public double getPrezzo() { return prezzo;}

	public String getTipo()
	{
		return tipo;
	}
	
}