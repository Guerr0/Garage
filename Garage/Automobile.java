package Garage;


import java.util.Random;

public abstract class  Automobile
{
	private String targa;
	private String numeroPatente;
	private Integer posto;

	public Automobile(String targa , String numeroPatente )
	{
		this.targa=targa;
		this.numeroPatente=numeroPatente;

		Random rand = new Random();
		boolean ris;
		do {
			ris = true;

			this.posto = rand.nextInt(15);

			for (int i = 0; i <  ControllerAggiungiMacchina.macchine.size(); i++)
			{
				Automobile a = ControllerAggiungiMacchina.macchine.get(i);

				if (a.getPosto() == this.posto)
				{
					ris = false;
				}
			}
		}
		while(ris==false);
	}
	public String getTarga()
	{
		return targa;
	}

	public String getNumeroPatente()
	{
		return numeroPatente;
	}

	public Integer getPosto()
	{
		return posto;
	}

	public abstract double getPrezzo();

	public abstract String getTipo();


	public String toString()
	{
		return "Targa: " + getTarga() +"\nNumero Patente: "+ getNumeroPatente() + "\nTipo: " +getTipo() +"\nPosto: "+getPosto();
	}
}


