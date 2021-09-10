package Garage;

public class Auto extends Automobile
{
	private double prezzo;
	private String tipo;

	public Auto(String targa , String numeroPatente)
	{
		super(targa,numeroPatente);
		this.prezzo=0.05;
		this.tipo = "AUTO";
	}
	public double getPrezzo() { return prezzo;}
	public String getTipo()
	{
		return tipo;
	}
	
}
